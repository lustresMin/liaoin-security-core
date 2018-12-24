package com.liaoin.security.core.properties.social;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author mc
 * @version 1.0
 * QQ配置属性
 */
@Data
public class QQProperties extends SocialProperties {
	/**
	 * 服务商标识
	 */
	private String providerId = "qq";
}
