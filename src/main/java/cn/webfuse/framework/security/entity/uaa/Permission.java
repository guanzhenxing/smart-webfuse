package cn.webfuse.framework.security.entity.uaa;

import java.util.List;

/**
 * 权限
 */
public class Permission {
    private String code;    //权限代码
    private String name;    //权限名称
    private String description; //权限描述
    private List<Operation> operations;  //操作
    private List<Resource> resources;    //资源

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
