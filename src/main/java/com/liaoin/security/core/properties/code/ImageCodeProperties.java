package com.liaoin.security.core.properties.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author mc
 * @version 1.0
 * 图片验证码属性配置
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties {

	/**
	 * 宽度
	 */
	private int width = 67;
	/**
	 * 高度
	 */
	private int height = 23;

	public ImageCodeProperties() {
		setLength(4);
	}
}
