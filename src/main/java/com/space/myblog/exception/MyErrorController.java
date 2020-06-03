package com.space.myblog.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController  implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, ModelMap m){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String msg = HttpStatus.valueOf(statusCode).getReasonPhrase();
        msg = statusCode.toString()+" "+msg;
        m.addAttribute("errorCode",msg);
        return "error/errorPage";

    }


    public boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null &&
                "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}