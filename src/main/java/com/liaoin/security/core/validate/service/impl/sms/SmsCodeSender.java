/**
 * 
 */
package com.liaoin.security.core.validate.service.impl.sms;

public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
