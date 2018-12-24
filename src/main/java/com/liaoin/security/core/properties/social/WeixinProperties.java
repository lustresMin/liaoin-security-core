package com.liaoin.security.core.properties.social;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import lombok.Data;

/**
 * @author mc
 * @version 1.0
 * 微信配置属性
 */
@Data
public class WeixinProperties extends SocialProperties {
	/**
	 * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
	 */
	private String providerId = "weixin";

}
