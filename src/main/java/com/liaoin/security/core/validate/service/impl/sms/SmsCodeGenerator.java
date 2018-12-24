/**
 * 
 */
package com.liaoin.security.core.validate.service.impl.sms;

import com.liaoin.security.core.properties.SecurityProperties;
import com.liaoin.security.core.validate.bean.ValidateCode;
import com.liaoin.security.core.validate.service.ValidateCodeGenerator;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Data
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

	@Autowired
	private SecurityProperties securityProperties;

	/**
	 * 返回短信验证码
	 */
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
		return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
	}

}
