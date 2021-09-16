package sonu.techie.orderservice.common;

import lombok.*;
import sonu.techie.orderservice.entity.Order;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Order order;
    private double amount;
    private String transactionId;
    private String message;

}
