package cn.webfuse.framework.tool;

import java.util.Map;

public class MapperTestBean {

    private String message;
    private Throwable throwable;
    private Object[] argArray;
    private long number;
    private Map<String, Object> map;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public void setArgArray(Object[] argArray) {
        this.argArray = argArray;
    }

    public String getMessage() {
        return message;
    }

    public Object[] getArgArray() {
        return argArray;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}