package com.liaoin.security.core.properties.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mc
 * @version 1.0v
 * 认证服务器注册的第三方应用配置项
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2Properties {
    private OAuth2ClientProperties[] clients = {};
    /**
     * 使用jwt时为token签名的密匙
     */
    private String jwtSigningKey = "liaoin";
}
