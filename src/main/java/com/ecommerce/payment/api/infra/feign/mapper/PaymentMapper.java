package com.ecommerce.payment.api.infra.feign.mapper;

import com.ecommerce.payment.api.domain.entity.Payment;
import com.ecommerce.payment.api.infra.feign.dto.response.PaymentResponse;
import com.stripe.model.PaymentIntent;

public interface PaymentMapper {

    PaymentResponse toPaymentResponse(PaymentIntent paymentIntent);

    Payment fromPaymentResponseToPayment(PaymentResponse paymentResponse);

    PaymentResponse fromPaymentToPaymentResponse(Payment payment);
}
