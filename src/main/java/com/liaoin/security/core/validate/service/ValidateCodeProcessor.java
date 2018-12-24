package com.liaoin.security.core.validate.service;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码处理器，封装不同校验码的处理逻辑
 */
public interface ValidateCodeProcessor {
	/**
	 * 创建校验码
	 * @param request request
	 * @throws Exception Exception
	 */
	void create(ServletWebRequest request) throws Exception;

	/**
	 * 校验验证码
	 * @param servletWebRequest servletWebRequest
	 */
	void validate(ServletWebRequest servletWebRequest);
}
