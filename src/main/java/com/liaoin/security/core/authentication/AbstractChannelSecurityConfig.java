package com.liaoin.security.core.authentication;

import com.liaoin.security.core.constants.SecurityConstants;
import com.liaoin.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler liaoinAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler liaoinAuthenticationFailureHandler;

    @Autowired
	private SecurityProperties securityProperties;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        //表单登陆
        http.formLogin()
                //当请求需要身份认证时，默认跳转的url
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                //默认的用户名密码登录请求处理url
                .loginProcessingUrl(securityProperties.getDefaultLoginProcessingUrlFrom())
                //自定义登陆成功配置
                .successHandler(liaoinAuthenticationSuccessHandler)
                //自定义登陆失败配置
                .failureHandler(liaoinAuthenticationFailureHandler)
				//登陆的账号属性名称
				.usernameParameter(securityProperties.getUsernameParameter())
				//登陆的密码属性名称
				.passwordParameter(securityProperties.getPasswordParameter());
    }
}
