package com.ecommerce.payment.api.application.controller;

import com.ecommerce.payment.api.domain.service.PaymentService;
import com.ecommerce.payment.api.infra.feign.dto.response.PaymentResponse;
import com.ecommerce.payment.api.infra.feign.mapper.PaymentMapper;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentMapper mapper;

    @PostMapping
    public ResponseEntity<PaymentResponse> createPaymentIntent(@RequestParam Long amount,
                                                               @RequestParam String currency,
                                                               @RequestParam String paymentMethod) throws StripeException {
        var payment = paymentService.sendPayment(amount, currency, paymentMethod);
        return new ResponseEntity<>(mapper.fromPaymentToPaymentResponse(payment), HttpStatus.CREATED);
    }
    // cool
}
