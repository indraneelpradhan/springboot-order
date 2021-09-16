package sonu.techie.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sonu.techie.orderservice.common.Payment;
import sonu.techie.orderservice.common.TransactionRequest;
import sonu.techie.orderservice.common.TransactionResponse;
import sonu.techie.orderservice.entity.Order;
import sonu.techie.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest){
    return orderService.saveOrder(transactionRequest);
    }
}
