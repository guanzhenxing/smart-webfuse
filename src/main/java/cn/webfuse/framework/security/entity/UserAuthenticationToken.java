package cn.webfuse.framework.security.entity;


import cn.webfuse.framework.security.entity.uaa.User;

public class UserAuthenticationToken extends AbstractUserAuthenticationToken {

    private User user;

    public UserAuthenticationToken(User user, String authType) {
        super(user.getAuthorities(), authType);
        setAuthenticated(true);
        this.user = user;
    }


    @Override
    public Object getCredentials() {
        return this.user.getAuthToken();
    }

    @Override
    public Object getPrincipal() {
        return this.user;
    }

}
