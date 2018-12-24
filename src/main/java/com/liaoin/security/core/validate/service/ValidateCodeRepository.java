package com.liaoin.security.core.validate.service;

import com.liaoin.security.core.validate.bean.ValidateCode;
import com.liaoin.security.core.validate.enums.ValidateCodeType;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author mc
 * @version 1.0v
 * 验证码重新构建，分别有app和PC不同的实现类
 */
public interface ValidateCodeRepository {
	/**
	 * 保存验证码
	 * @param request request
	 * @param code code
	 * @param validateCodeType validateCodeType
	 */
    void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType);

	/**
	 * 获取验证码
	 * @param request request
	 * @param validateCodeType validateCodeType
	 * @return ValidateCode
	 */
    ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);

	/**
	 * 移除验证码
	 * @param request request
	 * @param validateCodeType validateCodeType
	 */
    void remove(ServletWebRequest request, ValidateCodeType validateCodeType);

}
