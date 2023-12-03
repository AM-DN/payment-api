package com.ecommerce.payment.api.infra.feign.impl;

import com.ecommerce.payment.api.domain.dataprovider.PaymentDataProvider;
import com.ecommerce.payment.api.infra.feign.dto.response.PaymentResponse;
import com.ecommerce.payment.api.infra.feign.mapper.PaymentMapper;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentDataProviderImpl implements PaymentDataProvider {

    @Value("${payment_gateway.secret_key}")
    private String apiKey;

    private final PaymentMapper mapper;

    @Override
    public PaymentResponse createPaymentIntent(Long amount, String currency, String paymentMethod) throws StripeException {
        Stripe.apiKey = apiKey;
        PaymentIntent paymentIntent = PaymentIntent.create(
                new PaymentIntentCreateParams.Builder()
                        .setAmount(amount)
                        .setCurrency(currency)
                        .setPaymentMethod(paymentMethod)
                        .setConfirmationMethod(PaymentIntentCreateParams.ConfirmationMethod.MANUAL)
                        .setConfirm(true)
                        .build()
        );
        return mapper.toPaymentResponse(paymentIntent);
    }

}
