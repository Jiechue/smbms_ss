package com.smbms.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  //全局的异常处理控制器
public class MyExceptionController{

    //异常处理的方法
    @ExceptionHandler
  public String exceptionHandler(Exception e, Model model){
      model.addAttribute("msg",e);
      return "error";
  }
}

