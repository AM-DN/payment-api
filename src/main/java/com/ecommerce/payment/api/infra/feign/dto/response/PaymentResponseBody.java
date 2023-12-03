package com.ecommerce.payment.api.infra.feign.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseBody {

    private String id;
    private String object;
    private int amount;
}
