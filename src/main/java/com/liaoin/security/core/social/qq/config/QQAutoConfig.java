package com.liaoin.security.core.social.qq.config;

import com.liaoin.security.core.properties.SecurityProperties;
import com.liaoin.security.core.properties.social.QQProperties;
import com.liaoin.security.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @author mc
 * @version 1.0v
 * QQ链接工厂
 */
@Configuration
//当配置文件里面liaoin.security.social.qq被配置了才配置ConnectionFactory
@ConditionalOnProperty(prefix = "liaoin.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
    }
}
