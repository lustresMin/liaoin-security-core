package com.liaoin.security.core.social.qq.connet;

import com.liaoin.security.core.social.qq.api.QQ;
import com.liaoin.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @author mc
 * @version 1.0v
 * OAuth2Operations(OAuth2Template)与Api(AbstractOAuth2ApiBinding)控制
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    /**
     * 第三方服务器认证URL，即用户确认授权页面
     */
    private static final String URL_AUTHORIZE = "https://graph.qq.com/app.0/authorize";
    /**
     * 认证成功后获取token的url
     */
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/app.0/token";

    public QQServiceProvider(String appId, String appSecret) {
        //调用自定义QQOAuth2Template构造方法
        super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;

    }
    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }

}
