package com.ecommerce.payment.api.infra.feign;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stripeApi", url = "${spring.cloud.openfeign.client.config.stripeApi.url}")
public interface StripeFeignClient {

    @PostMapping("/create-payment-intent")
    PaymentIntent createPaymentIntent(@RequestParam Long amount,
                                      @RequestParam String currency,
                                      @RequestParam String paymentMethod) throws StripeException;
}
