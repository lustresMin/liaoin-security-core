package com.liaoin.security.core.properties;

import com.liaoin.security.core.constants.SecurityConstants;
import com.liaoin.security.core.properties.app.OAuth2Properties;
import com.liaoin.security.core.properties.browser.BrowserProperties;
import com.liaoin.security.core.properties.code.ValidateCodeProperties;
import com.liaoin.security.core.properties.social.SocialProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mc
 * @version 1.0
 * 封装配置入口类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "liaoin.security")
public class SecurityProperties {
	/**
	 * 浏览器配置相关
	 */
	private BrowserProperties browser = new BrowserProperties();
	/**
	 * 验证码相关配置项
	 */
	private ValidateCodeProperties code = new ValidateCodeProperties();
	/**
	 * 三方登陆相关配置项
	 */
	private SocialProperties social = new SocialProperties();
	/**
	 * OAuth2相关配置
	 */
	private OAuth2Properties oauth2 = new OAuth2Properties();
	/**
	 * 不需要验证的url
	 */
	private String[] noverify ={};
	/**
	 * 当请求需要身份认证时，默认跳转的url
	 */
	private String defaultLoginProcessingUrlFrom = "/authentication/form";
	/**
	 * 默认的登陆属性名称
	 */
	private String usernameParameter = SecurityConstants.DEFAULT_USER_NAME_PARAMETER;
	/**
	 * 登陆的密码属性名称
	 */
	private String passwordParameter = SecurityConstants.DEFAULT_PASSWORD_PARAMETER;
}
