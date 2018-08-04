package cn.webfuse.framework.web.controller;

import cn.webfuse.framework.support.SpringContextHolder;
import cn.webfuse.framework.validation.BeanValidator;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.beans.PropertyEditorSupport;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础的Controller，所有的Controller可以继承这个
 */
public class BaseController {

    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    protected Validator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }
        });
    }

    /**
     * 服务端参数有效性验证
     *
     * @param object 待验证的实体对象
     * @param groups 验证组
     * @return 验证失败的信息。如果数组为空代表验证成功。
     */
    protected Map<String, String> beanValidator(Object object, Class<?>... groups) {

        Map<String, String> errorMessages = new HashMap<>();
        try {
            BeanValidator.validateWithException(validator, object, groups);
        } catch (ConstraintViolationException ex) {
            errorMessages = BeanValidator.extractPropertyAndMessage(ex);
        }
        return errorMessages;
    }


    /**
     * 从Spring服务容器中获得Service对象
     *
     * @param serviceName 服务容器中Serice的名称
     * @return Service对象
     */
    protected Object getService(String serviceName) {
        return SpringContextHolder.getBean(serviceName);
    }


}
