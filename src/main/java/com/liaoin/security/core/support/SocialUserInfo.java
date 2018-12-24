package com.liaoin.security.core.support;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialUserInfo {
    /**
     * 当前是那个第三方用户在社交登陆
     */
    private String providerId;
    /**
     * OPENID
     */
    private String providerUserId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String headimg;
}
