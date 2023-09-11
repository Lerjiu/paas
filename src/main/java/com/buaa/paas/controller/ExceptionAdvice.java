package com.buaa.paas.controller;

import com.buaa.paas.controller.response.Response;
import com.buaa.paas.exception.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Response handleSystemException(SystemException systemException) {
        systemException.printStackTrace();
        return Response.fail(systemException.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Response handleBusinessException(BusinessException businessException) {
        businessException.printStackTrace();
        return Response.fail(businessException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception exception) {
        exception.printStackTrace();
        return Response.fail(ExceptionCode.UNKNOWN_EXCEPTION_MESSAGE);
    }
}
