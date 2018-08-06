package cn.webfuse.security.entity.uaa;

import cn.webfuse.security.entity.UserGrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class User {

    private String id;  //用户的ID
    private String account; //用户名
    private String realName;    //真实姓名
    private String nickName;    //昵称
    private Set<Role> roles; //角色
    private Set<Permission> permissions; //权限
    private AuthToken authToken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public AuthToken getAuthToken() {
        return authToken;
    }

    public void setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
    }

    public List<UserGrantedAuthority> getAuthorities() {
        Set<Permission> permissions = this.getPermissions();
        List<UserGrantedAuthority> authorities = Optional.ofNullable(permissions).orElse(new HashSet<>())
                .stream().map(getUaaPermissionUserGrantedAuthorityFunction()).collect(Collectors.toList());
        return authorities;
    }

    private Function<Permission, UserGrantedAuthority> getUaaPermissionUserGrantedAuthorityFunction() {
        return permission -> {
            UserGrantedAuthority authority = new UserGrantedAuthority();
            authority.setName(permission.getName());
            authority.setAuthority(permission.getCode());
            return authority;
        };
    }

}
