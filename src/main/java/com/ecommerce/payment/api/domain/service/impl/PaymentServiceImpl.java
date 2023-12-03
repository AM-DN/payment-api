package com.ecommerce.payment.api.domain.service.impl;

import com.ecommerce.payment.api.domain.dataprovider.PaymentDataProvider;
import com.ecommerce.payment.api.domain.entity.Payment;
import com.ecommerce.payment.api.domain.service.PaymentService;
import com.ecommerce.payment.api.infra.feign.mapper.PaymentMapper;
import com.ecommerce.payment.api.infra.repository.PaymentRepository;
import com.stripe.exception.StripeException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDataProvider paymentDataProvider;
    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;

    @Override
    @Transactional
    public Payment sendPayment(Long amount, String currency, String paymentMethod) throws StripeException {
        var paymentResponse = paymentDataProvider.createPaymentIntent(amount, currency, paymentMethod);
        return paymentRepository.save(mapper.fromPaymentResponseToPayment(paymentResponse));
    }

}
