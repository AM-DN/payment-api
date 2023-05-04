package com.ecommerce.payment.api.application.handler;


import com.ecommerce.payment.api.application.handler.wrapper.ErrorRequestVO;
import com.ecommerce.payment.api.application.handler.wrapper.ErrorResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(ErrorRequestVO.class)
    public ResponseEntity<ErrorResponseVO> errorBusiness(ErrorRequestVO error) {
        ErrorResponseVO errorResponseVO = ErrorResponseVO.builder()
                .status(HttpStatus.BAD_REQUEST)
                .timeStamp(LocalDateTime.now())
                .message(error.getMessage())
                .build();

        return buildResponseEntity(errorResponseVO);
    }

    public ResponseEntity<ErrorResponseVO> buildResponseEntity(ErrorResponseVO errorResponseVO) {
        return new ResponseEntity<>(errorResponseVO, errorResponseVO.status());
    }

}