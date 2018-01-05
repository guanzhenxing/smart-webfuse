package net.webfuse.common.exception.exhandler;

import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Restful 错误
 * Created by guanzhenxing on 2018/1/5.
 */
public class RestfulError {

    private final HttpStatus status;    //HTTP状态
    private final String code;  //用来表示某类错误,对HTTP状态的补充
    private final String message;   //错误信息摘要
    private final Throwable throwable;   //抛出的异常信息
    private final String developerMessage;  //开发者信息
    private final String document;   //更多信息的地址
    private final String requestId;   //请求的ID
    private final String hostId;  //服务ID
    private final Date serverTime;    //发生异常的实际

    public RestfulError(HttpStatus status, String code, String message, Throwable throwable, String developerMessage,
                        String document, String requestId, String hostId, Date serverTime) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.throwable = throwable;
        this.developerMessage = developerMessage;
        this.document = document;
        this.requestId = requestId;
        this.hostId = hostId;
        this.serverTime = serverTime;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public String getDocument() {
        return document;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getHostId() {
        return hostId;
    }

    public Date getServerTime() {
        return serverTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestfulError that = (RestfulError) o;
        if (status != that.status) return false;
        if (!code.equals(that.code)) return false;
        if (!message.equals(that.message)) return false;
        if (!throwable.equals(that.throwable)) return false;
        if (!developerMessage.equals(that.developerMessage)) return false;
        if (!document.equals(that.document)) return false;
        if (!requestId.equals(that.requestId)) return false;
        if (!hostId.equals(that.hostId)) return false;
        return serverTime.equals(that.serverTime);
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + throwable.hashCode();
        result = 31 * result + developerMessage.hashCode();
        result = 31 * result + document.hashCode();
        result = 31 * result + requestId.hashCode();
        result = 31 * result + hostId.hashCode();
        result = 31 * result + serverTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RestfulError{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", throwable=" + throwable +
                ", developerMessage='" + developerMessage + '\'' +
                ", document='" + document + '\'' +
                ", requestId='" + requestId + '\'' +
                ", hostId='" + hostId + '\'' +
                ", serverTime=" + serverTime +
                '}';
    }

    public static class Builder {
        private HttpStatus status;
        private String code;
        private String message;
        private Throwable throwable;
        private String developerMessage;
        private String document;
        private String requestId;
        private String hostId;
        private Date serverTime;

        public Builder() {
        }

        public Builder setStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setThrowable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }

        public Builder setDocument(String document) {
            this.document = document;
            return this;
        }

        public Builder setDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder setHostId(String hostId) {
            this.hostId = hostId;
            return this;
        }

        public Builder setServerTime(Date serverTime) {
            this.serverTime = serverTime;
            return this;
        }


        public RestfulError build() {
            if (this.status == null) {
                this.status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            return new RestfulError(status, code, message, throwable, developerMessage, document, requestId, hostId, serverTime);
        }

    }


}
