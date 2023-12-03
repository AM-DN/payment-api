package com.ecommerce.payment.api.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private String intent;
    private String currency;
    private String status;
    private String method;
    private String clientSecret;
    private String receiptUrl;

    @Lob
    @Column(name = "json_response")
    private String responseBody;
}
