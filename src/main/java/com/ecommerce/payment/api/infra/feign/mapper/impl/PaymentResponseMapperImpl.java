package com.ecommerce.payment.api.infra.feign.mapper.impl;

import com.ecommerce.payment.api.domain.entity.Payment;
import com.ecommerce.payment.api.infra.feign.dto.response.PaymentResponse;
import com.ecommerce.payment.api.infra.feign.mapper.PaymentMapper;
import com.stripe.model.PaymentIntent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.ecommerce.payment.api.infra.feign.mapper.impl.PaymentConverter.getReceiptUrl;

@Component
public class PaymentResponseMapperImpl implements PaymentMapper {

    @Override
    public PaymentResponse toPaymentResponse(PaymentIntent paymentIntent) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setObject(paymentIntent.getObject());
        paymentResponse.setAmount(paymentIntent.getAmount());
        paymentResponse.setCurrency(paymentIntent.getCurrency());
        paymentResponse.setStatus(paymentIntent.getStatus());
        paymentResponse.setPaymentMethod(paymentIntent.getPaymentMethod());
        paymentResponse.setClientSecret(paymentIntent.getClientSecret());
        paymentResponse.setResponseBody(paymentIntent.getLastResponse().body());
        getReceiptUrl(paymentIntent, paymentResponse);

        return paymentResponse;
    }

    @Override
    public Payment fromPaymentResponseToPayment(PaymentResponse paymentResponse) {
        return Payment.builder()
                .amount(BigDecimal.valueOf(paymentResponse.getAmount()))
                .intent(paymentResponse.getObject())
                .currency(paymentResponse.getCurrency())
                .method(paymentResponse.getPaymentMethod())
                .status(paymentResponse.getStatus())
                .clientSecret(paymentResponse.getClientSecret())
                .responseBody(paymentResponse.getResponseBody())
                .receiptUrl(paymentResponse.getReceiptUrl())
                .build();
    }

    @Override
    public PaymentResponse fromPaymentToPaymentResponse(Payment payment) {
        return PaymentResponse.builder()
                .object(payment.getIntent())
                .amount(payment.getAmount().longValue())
                .currency(payment.getCurrency())
                .status(payment.getStatus())
                .receiptUrl(payment.getReceiptUrl())
                .build();
    }

}
