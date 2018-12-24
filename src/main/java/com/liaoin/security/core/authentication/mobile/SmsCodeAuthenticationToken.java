package com.liaoin.security.core.authentication.mobile;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * 与UsernamePasswordAuthenticationToken内容一致，同样继承AbstractAuthenticationToken
 * 实现自定义TOKEN认证
 * @author Administrator
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    /**
     * 存放认证信息，认证之前存手机号，认证之后存放用户信息
     */
    private final Object principal;

    /**
     * 未认证时存入手机号
     * @param mobile 手机号码
     */
    public SmsCodeAuthenticationToken(String mobile) {
        super(null);
        this.principal = mobile;
        setAuthenticated(false);
    }

    /**
     * 登陆成功存放用户信息
     * @param principal 用户信息
     * @param authorities 认证信息集合
     */
    public SmsCodeAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        // must use super, as we override
        super.setAuthenticated(true);
    }


    @Override
	public Object getCredentials() {
        return null;
    }

    @Override
	public Object getPrincipal() {
        return this.principal;
    }

    @Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}
