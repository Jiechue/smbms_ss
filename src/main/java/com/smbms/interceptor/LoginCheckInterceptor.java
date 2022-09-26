package com.smbms.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckInterceptor implements HandlerInterceptor {

    //预处理，拦截非登录用户访问
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      //获取session作用域的用户数据
        Object user = request.getSession().getAttribute("user");
        if(user!=null){
            //放行
            return true;
        }
        //跳转到login.jsp
        response.sendRedirect(request.getContextPath()+"/login.jsp");

        return false;
    }
}
