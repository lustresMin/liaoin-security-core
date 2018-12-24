package com.liaoin.security.core.social.qq.connet;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * @author mc
 * @version 1.0v
 * 重写OAuth2Template的createRestTemplate方法，新增text/html类型读取
 */
public class QQOAuth2Template extends OAuth2Template {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
        //使social自带的值生效，源码87行，因为：QQ获取token请求的接口参数刚好是springsoial都有的
        setUseParametersForClientAuthentication(true);
    }

    /**
     * 重写获取数据解析格式，并返回AccessGrant
     * QQ返回的特有
     */
    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        String responseStr = getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);

        logger.info("获取accessToke的响应："+responseStr);

        String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(responseStr, "&");

        String accessToken = StringUtils.substringAfterLast(items[0], "=");
        Long expiresIn = new Long(StringUtils.substringAfterLast(items[1], "="));
        String refreshToken = StringUtils.substringAfterLast(items[2], "=");

        return new AccessGrant(accessToken, null, refreshToken, expiresIn);
    }

    @Override
    protected RestTemplate createRestTemplate() {
        //获取父类创建结果
        RestTemplate restTemplate = super.createRestTemplate();
        //新增Converters的text/html类型处理
        //StringHttpMessageConverter可以处理该类型
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }
}
