package com.example.payment_service.dto;

import lombok.Data;

@Data
public class PaymentResponse {
    private boolean success;
    private String transactionId;
}