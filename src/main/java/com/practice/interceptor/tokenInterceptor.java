package com.practice.interceptor;

import com.practice.vo.TokenVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class tokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String tokenID = httpServletRequest.getParameter(TokenVO.TOKEN_ID);
        if (tokenID != null) {
            //TODO 是否重复提交判断
        }
        System.out.println("tokenInterceptor.preHandle()");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("tokenInterceptor.postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("tokenInterceptor.afterCompletion()");
    }
}
