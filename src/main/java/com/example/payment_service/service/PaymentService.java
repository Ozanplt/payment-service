package com.example.payment_service.service;

import com.example.payment_service.dto.PaymentRequest;
import com.example.payment_service.dto.PaymentResponse;
import com.example.payment_service.model.Payment;
import com.example.payment_service.repository.PaymentRepository;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    public PaymentResponse process(PaymentRequest request) {
        try{
            // to-do real gateway integration
            Payment p = new Payment();
            p.setOrderId(request.getOrderId());
            p.setAmount(request.getAmount());
            p.setStatus("SUCCESS");
            repo.save(p);

            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setSuccess(true);
            paymentResponse.setTransactionId(request.getOrderId().toString());

            return paymentResponse;
        }catch (Exception e){
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setSuccess(false);
            paymentResponse.setTransactionId(request.getOrderId().toString());

            return paymentResponse;
        }

    }
}
