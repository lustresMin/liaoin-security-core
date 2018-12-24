package com.liaoin.security.core.social;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author mc
 * @version 1.0v
 */
@Data
public class LiaoinSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

    public LiaoinSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        if (socialAuthenticationFilterPostProcessor != null){
            socialAuthenticationFilterPostProcessor.processor(filter);
        }
        return (T) filter;
    }
}
