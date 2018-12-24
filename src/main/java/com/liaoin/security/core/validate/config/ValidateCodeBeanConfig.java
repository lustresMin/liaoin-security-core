package com.liaoin.security.core.validate.config;

import com.liaoin.security.core.properties.SecurityProperties;
import com.liaoin.security.core.validate.service.ValidateCodeGenerator;
import com.liaoin.security.core.validate.service.impl.image.ImageCodeGenerator;
import com.liaoin.security.core.validate.service.impl.sms.DefaultSmsCodeSender;
import com.liaoin.security.core.validate.service.impl.sms.SmsCodeGenerator;
import com.liaoin.security.core.validate.service.impl.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {
    @Autowired
    private SecurityProperties securityProperties;

	/**
	 * 如果容器中不存在imageValidateCodeGenerator bean就执行该方法
	 * @return ValidateCodeGenerator
	 */
	@Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

	/**
	 * 如果容器中不存在SmsCodeSender bean就执行该方法
	 * @return SmsCodeSender
	 */
	@Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
