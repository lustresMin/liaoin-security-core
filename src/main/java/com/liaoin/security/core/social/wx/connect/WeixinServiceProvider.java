/**
 * 
 */
package com.liaoin.security.core.social.wx.connect;

import com.liaoin.security.core.social.wx.api.Weixin;
import com.liaoin.security.core.social.wx.api.WeixinImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;



/**
 * @author mc
 * @version 1.0v
 * 微信的OAuth2流程处理器的提供器，供spring social的connect体系调用
 */
public class WeixinServiceProvider extends AbstractOAuth2ServiceProvider<Weixin> {
	
	/**
	 * 微信获取授权码的url
	 */
	private static final String URL_AUTHORIZE = "https://open.weixin.qq.com/connect/qrconnect";
	/**
	 * 微信获取accessToken的url
	 */
	private static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/app/access_token";

	public WeixinServiceProvider(String appId, String appSecret) {
		super(new WeixinOAuth2Template(appId, appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
	}


	/* (non-Javadoc)
	 * @see org.springframework.social.app.AbstractOAuth2ServiceProvider#getApi(java.lang.String)
	 */
	@Override
	public Weixin getApi(String accessToken) {
		return new WeixinImpl(accessToken);
	}

}
