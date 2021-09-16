package sonu.techie.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sonu.techie.orderservice.entity.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private Order order;
    private Payment payment;

    public Order getOrder(){

        return this.order;
    };

    public Payment getPayment(){
        return this.payment;
    };
}
