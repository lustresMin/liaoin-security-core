package com.liaoin.security.core.properties.browser;

import com.liaoin.security.core.constants.SecurityConstants;
import com.liaoin.security.core.enums.LoginResponseType;
import com.liaoin.security.core.properties.SessionProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mc
 * @version 1.0
 * 浏览器相关配置项
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrowserProperties {

	private SessionProperties session = new SessionProperties();
	/**
	 * 默认注册页面
	 */
	private String signUpUrl = SecurityConstants.DEFAULT_SING_UP_URL;
	/**
	 * 默认退出页面
	 */
	private String signOutUrl = SecurityConstants.DEFAULT_SING_OUT_URL;
	/**
	 * 默认登录页面
	 */
	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;
	/**
	 * 登陆返回方式
	 */
	private LoginResponseType loginType = LoginResponseType.JSON;
	/**
	 * 记住我的过期时间（单位:秒）
	 */
	private int rememberMeSeconds = 3600;
}
