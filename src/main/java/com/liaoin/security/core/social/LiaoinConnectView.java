package com.liaoin.security.core.social;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author mc
 * @version 1.0v
 * 微信绑定默认返回视图
 */
public class LiaoinConnectView  extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        //判断model是否有connection
        if (model.get("connection") == null) {
            response.getWriter().write("<h3>解绑成功</h3>");
        } else {
            response.getWriter().write("<h3>绑定成功</h3>");
        }

    }
}
