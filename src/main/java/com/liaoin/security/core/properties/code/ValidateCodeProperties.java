package com.liaoin.security.core.properties.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mc
 * @version 1.0
 * 验证码相关配置项
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidateCodeProperties {
	/**
	 * 图片验证码
	 */
	private ImageCodeProperties image = new ImageCodeProperties();
	/**
	 * 短信验证码
	 */
	private SmsCodeProperties sms = new SmsCodeProperties();

	/**
	 * 验证码放入session时的前缀
	 */
	private String sessionKeyPrefix = "SESSION_KEY_FOR_CODE_";
}
