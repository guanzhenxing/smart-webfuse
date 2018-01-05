package net.webfuse.common.exception.exhandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * RestfulError解析器
 * Created by guanzhenxing on 2018/1/5.
 */
public interface RestfulErrorResolver {


    /**
     * 解析错误
     *
     * @param request  request请求对象
     * @param response response返回对象
     * @param handler  处理器
     * @param ex       待处理的异常
     * @return 处理后的RestfulError信息
     */
    RestfulError resolveError(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex);

}
