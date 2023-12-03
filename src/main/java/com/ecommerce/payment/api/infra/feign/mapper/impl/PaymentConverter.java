package com.ecommerce.payment.api.infra.feign.mapper.impl;

import com.ecommerce.payment.api.infra.feign.dto.response.PaymentResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.model.PaymentIntent;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter {

    private PaymentConverter() {
    }

    public static String getReceiptUrl(PaymentIntent paymentIntent, PaymentResponse paymentResponse) {
        String body = paymentIntent.getLastResponse().body();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree(body);
            paymentResponse.setReceiptUrl(json.path("charges").path("data").get(0).path("receipt_url").asText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentResponse.getReceiptUrl();
    }

}
