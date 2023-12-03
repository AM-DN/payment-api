package com.ecommerce.payment.api.domain.service;

import com.ecommerce.payment.api.domain.entity.Payment;
import com.stripe.exception.StripeException;

public interface PaymentService {

    Payment sendPayment(Long amount, String currency, String paymentMethod) throws StripeException;
}
