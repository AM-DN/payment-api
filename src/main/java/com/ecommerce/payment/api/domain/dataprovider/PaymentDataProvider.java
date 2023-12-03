package com.ecommerce.payment.api.domain.dataprovider;

import com.ecommerce.payment.api.infra.feign.dto.response.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentDataProvider {

    PaymentResponse createPaymentIntent(Long amount, String currency, String paymentMethod) throws StripeException;
}
