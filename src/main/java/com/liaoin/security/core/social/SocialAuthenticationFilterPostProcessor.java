package com.liaoin.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @author mc
 * @version 1.0v
 * 后处理器
 */
public interface SocialAuthenticationFilterPostProcessor {
    void processor(SocialAuthenticationFilter socialAuthenticationFilter);
}
