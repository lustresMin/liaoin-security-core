package com.liaoin.security.core.authorize.impl;

import com.liaoin.security.core.authorize.AuthorizeCofigProvider;
import com.liaoin.security.core.constants.SecurityConstants;
import com.liaoin.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author mc
 * @version 1.0v
 */
@Component
@Order(Integer.MIN_VALUE)
public class AuthorizeCofigProviderImpl implements AuthorizeCofigProvider {
    @Autowired
    private SecurityProperties securityProperties;
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		//当请求需要身份认证时，默认跳转到controller层的url：/authentication/require
		if (securityProperties.getNoverify() != null && securityProperties.getNoverify().length != 0){
			String[] noverify = securityProperties.getNoverify();
			for (String url:noverify){
				config.antMatchers(url).permitAll();
			}
		}
		config.antMatchers(
				SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                securityProperties.getBrowser().getLoginPage(),
                SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
                //跳转到用户配置的登陆页
                securityProperties.getBrowser().getSignUpUrl(),
                securityProperties.getBrowser().getSession().getSessionInvalidUrl()+".json",
                securityProperties.getBrowser().getSession().getSessionInvalidUrl()+".html",
                securityProperties.getBrowser().getSignOutUrl()
				)
                .permitAll();

    }
}
