package com.liaoin.security.core.properties.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mc
 * @version 1.0v
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2ClientProperties {

    private String clientId;

    private String clientIdSecret;

    private int accessTokenValiditySeconds = 7200;
}
