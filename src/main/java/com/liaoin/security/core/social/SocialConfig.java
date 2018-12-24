package com.liaoin.security.core.social;

import com.liaoin.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author mc
 * @version 1.0v
 * 社交配置适配器
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    @Autowired(required = false)
    private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

	/**
	 * 构建UsersConnectionRepository
	 * @param connectionFactoryLocator 连接工厂
	 * @return 值
	 */
	@Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        //Encryptors 用于加解密  .noOpText()显示明文
        //需要手工执行JdbcUsersConnectionRepository.sql文件，创建UserConnection表
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
                connectionFactoryLocator, Encryptors.noOpText());
        //设置表的前缀
        repository.setTablePrefix("liaoin_");
        //是否开启默认三方账号自动创建系统账号，需要自己的业务中实现ConnectionSignUp并重写execute方法
        if(connectionSignUp != null) {
            repository.setConnectionSignUp(connectionSignUp);
        }
        return repository;
    }

    @Bean
    public SpringSocialConfigurer liaoinSocialSecurityConfig() {
        String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
        LiaoinSpringSocialConfigurer configurer = new LiaoinSpringSocialConfigurer(filterProcessesUrl);
        //把后处理器对象放入配置
        configurer.setSocialAuthenticationFilterPostProcessor(socialAuthenticationFilterPostProcessor);
        //如果是第一次，跳转到注册页面
        configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return configurer;
    }

	/**
	 * soial工具类，可以取得用户信息和三方授权的用户的信息
	 * @param connectionFactoryLocator 连接工厂
	 * @return 工具类
	 */
	@Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
        return new ProviderSignInUtils(connectionFactoryLocator,
                getUsersConnectionRepository(connectionFactoryLocator)) {};
    }
}
