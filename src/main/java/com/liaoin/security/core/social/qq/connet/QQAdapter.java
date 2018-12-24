package com.liaoin.security.core.social.qq.connet;

import com.liaoin.security.core.social.qq.api.QQ;
import com.liaoin.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author mc
 * @version 1.0v
 * 用于第三方获取的用户数据与springSocial做适配，适配类型为：com.liaoin.security.core.social.qq.api.QQ
 */
public class QQAdapter implements ApiAdapter<QQ> {
    /**
     * 用于当前接口请求是否是通的
     */
    @Override
    public boolean test(QQ api) {
        return true;
    }

    /**
     * 在connection与API之间适配
     */
    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = api.getUserInfo();
        //显示的用户名称
        values.setDisplayName(userInfo.getNickname());
        //用户头像
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        //QQ没有个人主页，设置为空
        values.setProfileUrl(null);
        //用户在三方服务商唯一的ID
        values.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 更新消息，主要用于微博
     */
    @Override
    public void updateStatus(QQ api, String message) {
        //do noting
    }
}
