package com.liaoin.security.core.social.qq.connet;

import com.liaoin.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author mc
 * @version 1.0v
 * 认证工厂
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {
    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        //super(providerId, serviceProvider, apiAdapter);
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
