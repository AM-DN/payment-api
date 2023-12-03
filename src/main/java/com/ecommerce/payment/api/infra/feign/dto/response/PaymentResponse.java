package com.ecommerce.payment.api.infra.feign.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResponse {

    private String object;
    private Long amount;
    private String currency;
    private String status;
    private String clientSecret;
    private int statusCode;
    private String paymentMethod;
    private String responseBody;
    private String receiptUrl;
}
