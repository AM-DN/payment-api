package com.ecommerce.payment.api.infra.repository;

import com.ecommerce.payment.api.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
