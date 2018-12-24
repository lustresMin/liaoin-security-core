package com.liaoin.security.core.validate.service;

import com.liaoin.security.core.validate.bean.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
	/**
	 * 获取验证码
	 * @param request request
	 * @return ValidateCode
	 */
	ValidateCode generate(ServletWebRequest request);
}
