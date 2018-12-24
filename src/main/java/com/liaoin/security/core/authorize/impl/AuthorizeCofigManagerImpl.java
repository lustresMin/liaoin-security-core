package com.liaoin.security.core.authorize.impl;

import com.liaoin.security.core.authorize.AuthorizeCofigManager;
import com.liaoin.security.core.authorize.AuthorizeCofigProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.naming.ldap.PagedResultsControl;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author mc
 * @version 1.0v
 */
@Component
public class AuthorizeCofigManagerImpl implements AuthorizeCofigManager {
    @Autowired
    private List<AuthorizeCofigProvider> authorizeCofigProviders;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        for (AuthorizeCofigProvider authorizeCofigProvider : authorizeCofigProviders){
            authorizeCofigProvider.config(config);
        }
//        config.anyRequest().authenticated();
    }
}
