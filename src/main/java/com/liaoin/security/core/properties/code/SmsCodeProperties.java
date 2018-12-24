package com.liaoin.security.core.properties.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mc
 * @version 1.0
 * 短信验证码属性配置
 */

@Data
public class SmsCodeProperties {
	/**
	 * 长度
	 */
	private int length = 6;
	/**
	 * 过期时间
	 */
	private int expireIn = 60;
	/**
	 * 那些拦截需要验证码
	 */
	private String url;
}
