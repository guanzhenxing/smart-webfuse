package cn.webfuse.framework.core.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现Bean与Map之间的转换工具类
 */
public class BeanMapUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private BeanMapUtil() {
    }

    /**
     * 将Map对象转换成Bean对象
     *
     * @param map 待转换的Map对象
     * @param obj 转换后的Bean对象
     */
    // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
    @Deprecated
    public static void convertMapToBean(Map<String, Object> map, Object obj) {

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                Class type = property.getPropertyType();

                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    if (Objects.nonNull(value)) {   //首先判断是不是空，如果不为空的话设置值
                        if (type == Date.class) {
                            value = new ISO8601DateFormat().parse(value.toString());
                        }
                        Method setter = property.getWriteMethod();// 得到property对应的setter方法
                        setter.invoke(obj, value);
                    }
                }
            }

        } catch (Exception e) {
            LOGGER.error("transMap2Bean Error " + e);
            ExceptionUtil.throwException(e);
        }
    }

    /**
     * 将Map对象转换成Bean对象
     *
     * @param fromValue   待转换的Map对象
     * @param toValueType 待转换成的类型
     * @param <T>
     * @return 转换后的对象
     */
    public static <T> T convertMapToBean(Map<String, Object> fromValue, Class<T> toValueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.convertValue(fromValue, toValueType);
    }

    /**
     * 将Bean对象转换成Map对象
     *
     * @param bean 待转的Bean对象
     * @return 转换后的Map对象
     */
    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
    public static Map<String, Object> convertBeanToMap(Object bean) {

        if (bean == null) {
            return null;
        }
        Map<String, Object> returnMap = new ConcurrentHashMap<>();

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(bean);
                    if (Objects.nonNull(value)) {
                        returnMap.put(key, value);
                    }
                }
            }

        } catch (Exception e) {
            LOGGER.error("convertBeanToMap Error " + e);
            ExceptionUtil.throwException(e);
        }
        return returnMap;

    }

    /**
     * 将不是null的属性转出成map
     *
     * @param bean
     * @return
     */
    public static Map<String, Object> convertToMapWithNonNullProperties(Object bean) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        try {
            Arrays.asList(Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors())
                    .stream()
                    .filter(pd -> Objects.nonNull(pd.getReadMethod()))
                    .forEach(pd -> {
                        try {
                            Object value = pd.getReadMethod().invoke(bean);
                            if (value != null) {
                                map.put(pd.getName(), value);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            return map;
        } catch (IntrospectionException e) {
            LOGGER.error("convertToMapWithNonNullProperties Error " + e);
            return Collections.emptyMap();
        }
    }

}
