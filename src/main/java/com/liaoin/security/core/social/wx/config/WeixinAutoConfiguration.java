/**
 * 
 */
package com.liaoin.security.core.social.wx.config;

import com.liaoin.security.core.properties.SecurityProperties;
import com.liaoin.security.core.properties.social.WeixinProperties;
import com.liaoin.security.core.social.LiaoinConnectView;
import com.liaoin.security.core.social.wx.connect.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;


/**
 * @author mc
 * @version 1.0v
 * 微信登录配置
 */
@Configuration
@ConditionalOnProperty(prefix = "liaoin.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
		return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
				weixinConfig.getAppSecret());
	}

	/**
	 * 微信解绑和绑定
	 * @return 返回自定义视图
	 */
	@Bean({"connect/weixinConnect", "connect/weixinConnected"})
	@ConditionalOnMissingBean(name = "weixinConnectedView")
	public View weixinConnectedView() {
		return new LiaoinConnectView();
	}
	
}
