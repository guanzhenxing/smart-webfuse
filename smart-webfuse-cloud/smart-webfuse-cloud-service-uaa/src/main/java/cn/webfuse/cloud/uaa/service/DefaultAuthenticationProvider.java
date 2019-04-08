package cn.webfuse.cloud.uaa.service;

import cn.webfuse.cloud.uaa.entity.AppUser;
import cn.webfuse.cloud.uaa.repository.AppUserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;

public class DefaultAuthenticationProvider implements AuthenticationProvider {


    private final AppUserRepository appUserRepository;

    public DefaultAuthenticationProvider(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.getName() == null || authentication.getCredentials() == null) {
            return null;
        }

        final String userEmail = authentication.getName();
        final Object userPassword = authentication.getCredentials();

        if (userEmail == null || userPassword == null) {
            return null;
        }

        if (userEmail.isEmpty() || userPassword.toString().isEmpty()) {
            return null;
        }

        final Optional<AppUser> appUser = this.appUserRepository.findById(authentication.getName());
        if (appUser.isPresent()) {
            final AppUser user = appUser.get();
            final String providedUserEmail = authentication.getName();
            final Object providedUserPassword = authentication.getCredentials();

            if (providedUserEmail.equalsIgnoreCase(user.getUserEmail())
                    && providedUserPassword.equals(user.getUserPass())) {
                return new UsernamePasswordAuthenticationToken(
                        user.getUserEmail(),
                        user.getUserPass(),
                        Collections.singleton(new SimpleGrantedAuthority(user.getUserRole())));
            }
        }

        throw new UsernameNotFoundException("Invalid username or password.");
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
