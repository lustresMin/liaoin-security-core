package com.liaoin.security.core.properties.social;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mc
 * @version 1.0
 * 三方登陆相关配置项
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialProperties {
	/**
	 * 过滤链需要过滤器验证的url地址
	 */
	private String filterProcessesUrl = "/auth";

	private QQProperties qq = new QQProperties();

	private WeixinProperties weixin = new WeixinProperties();
}
