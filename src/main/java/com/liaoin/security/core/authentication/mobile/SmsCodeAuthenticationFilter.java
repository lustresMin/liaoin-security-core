package com.liaoin.security.core.authentication.mobile;

import com.liaoin.security.core.constants.SecurityConstants;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 与UsernamePasswordAuthenticationProcessingFilter内容一致，同样继承AbstractAuthenticationProcessingFilter
 * @author Administrator
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * 在请求中，携带参数的名字
     */
    private String mobileParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
    /**
     * 指定当前过滤器只处理POST请求
     */
    private boolean postOnly = true;

    /**
     * 指定过滤器处理的请求
     */
    public SmsCodeAuthenticationFilter() {
        super(new AntPathRequestMatcher(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE, "POST"));
    }

    @Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("认证请求不支持: " + request.getMethod());
        }
        //获取手机号
        String mobile = obtainMobile(request);

        if (mobile == null) {
            mobile = "";
        }
        //去空格
        mobile = mobile.trim();
        //实例化自定义token处理类
        SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(mobile);
        //调用spring AuthenticationManager处理
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }


    /**
     * 获取手机号
     */
	private String obtainMobile(HttpServletRequest request) {
        return request.getParameter(mobileParameter);
    }

    private void setDetails(HttpServletRequest request, SmsCodeAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    public void setMobileParameter(String usernameParameter) {
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.mobileParameter = usernameParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getMobileParameter() {
        return mobileParameter;
    }
}
