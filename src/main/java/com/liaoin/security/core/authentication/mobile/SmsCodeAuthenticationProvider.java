package com.liaoin.security.core.authentication.mobile;

import lombok.Data;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 自定义手机登陆效验逻辑
 */
@Data
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    /**
     * 效验逻辑
     * @param authentication 认证
     * @return 返回认证信息
     * @throws AuthenticationException 认证异常
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;
        //取得手机号
        UserDetails user = userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());
        if (user == null) {
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }

        SmsCodeAuthenticationToken authenticationResult = new SmsCodeAuthenticationToken(user, user.getAuthorities());

        authenticationResult.setDetails(authenticationToken.getDetails());

        return authenticationResult;
    }

    /**
     * 指定自定义处理类
     * @param authentication 认证泛型
     * @return 布尔值
     */
    @Override
    public boolean supports(Class<?> authentication) {
        //判断authentication传进来的是否自定义SmsCodeAuthenticationToken类
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
