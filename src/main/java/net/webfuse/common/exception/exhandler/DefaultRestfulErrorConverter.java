package net.webfuse.common.exception.exhandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认的RestfulError转换器，默认转换为Map。也就是在这里输出异常的格式：<br/>
 * <pre>
 * {
 *    "code":"",
 *    "message":"",
 *    "document":"",
 *    "developer_message":{
 *        "throwable":{},
 *        "request_id":"",
 *        "host_id":"",
 *        "server_time":"",
 *        "exception_message":""
 *    }
 * }
 * </pre>
 * Created by guanzhenxing on 2018/1/5.
 */
public class DefaultRestfulErrorConverter implements RestfulErrorConverter<Map> {

    private final String codeKey = "code";
    private final String messageKey = "message";
    private final String documentKey = "document";
    private final String developerMessageKey = "developer_message";
    private final String throwableKey = "throwable";
    private final String requestIdKey = "request_id";
    private final String hostIdKey = "host_id";
    private final String serverTimeKey = "server_time";
    private final String exceptionMessageKey = "exception_message";


    @Override
    public Map convert(RestfulError restfulError) {

        Map<String, Object> res = new ConcurrentHashMap<>();
        res.put(codeKey, restfulError.getCode());
        res.put(messageKey, restfulError.getMessage());
        res.put(documentKey, restfulError.getDocument());

        Map<String, Object> devMsg = new ConcurrentHashMap();
        devMsg.put(throwableKey, restfulError.getThrowable());
        devMsg.put(requestIdKey, restfulError.getRequestId());
        devMsg.put(hostIdKey, restfulError.getHostId());
        devMsg.put(serverTimeKey, restfulError.getServerTime());
        devMsg.put(exceptionMessageKey, restfulError.getDeveloperMessage());

        res.put(developerMessageKey, devMsg);

        return res;
    }
}
