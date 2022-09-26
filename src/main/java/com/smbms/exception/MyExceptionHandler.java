package com.smbms.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@Component
//自定义一个异常处理类，必须实现HandlerExceptionResolver
public class MyExceptionHandler implements HandlerExceptionResolver {

    //异常处理方法
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("error");
        mv.addObject("message",e);
        return mv;
    }
}
