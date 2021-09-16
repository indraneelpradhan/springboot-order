package sonu.techie.orderservice.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import sonu.techie.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}