package com.ecommerce.payment.api.application.handler.wrapper;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class ErrorRequestVO extends RuntimeException implements Serializable {

    public ErrorRequestVO(String message) {
        super(message);
    }

}
