package com.tangmran.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 唐梦然
 * @date 2022/11/11
 * @note
 */
public class RequestInterceptor implements HandlerInterceptor {

    // 处理方法之前
    // 返回 false，就被拦截；返回 true 就放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("爷是preHandle,爷要开始拦截了");
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user==null){
            return false;
        }else {
            return true;
        }

    }

}
