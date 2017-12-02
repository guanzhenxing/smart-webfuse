package net.webfuse.uaa.user.domain;

import java.util.Date;

/**
 * 用户实体
 */
public class User {
    private Long id;

    private String username;

    private String password;

    private Byte accountNonExpired;

    private Byte accountNonLocked;

    private Byte credentialsNonExpired;

    private Date createTime;

    private Date updateTime;

    private Boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Byte accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Byte getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Byte accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Byte getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Byte credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}