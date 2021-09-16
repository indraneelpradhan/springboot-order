package sonu.techie.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sonu.techie.orderservice.common.Payment;
import sonu.techie.orderservice.common.TransactionRequest;
import sonu.techie.orderservice.common.TransactionResponse;
import sonu.techie.orderservice.entity.Order;
import sonu.techie.orderservice.respository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest){
        String response = "";
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setAmount(order.getPrice());
        payment.setOrderId(order.getId());
        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment, Payment.class);
        System.out.println(paymentResponse.getPaymentStatus());
        response = paymentResponse.getPaymentStatus().equals("success") ? "Payment Processing Successful and order place": "their is failure in payment api";
        repository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
