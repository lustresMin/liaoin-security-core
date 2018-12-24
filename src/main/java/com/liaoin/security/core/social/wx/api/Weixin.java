/**
 * 
 */
package com.liaoin.security.core.social.wx.api;

/**
 * @author mc
 * @version 1.0v
 * 微信API调用接口
 */
public interface Weixin {

	WeixinUserInfo getUserInfo(String openId);
	
}
