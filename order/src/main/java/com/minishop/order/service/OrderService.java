package com.minishop.order.service;

import com.minishop.shared.entity.Order;
import com.minishop.shared.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minishop.shared.entity.OrderItem;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // CREATE ORDER
    public Order createOrder(Order order) {

        for (OrderItem item : order.getOrderItems()) {
            item.setOrder(order);
        }

        return orderRepository.save(order);
    }

    // GET ALL ORDERS
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // GET ORDER BY ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // UPDATE ORDER
    public Order updateOrder(Long id, Order order) {

        Order existingOrder =
                orderRepository.findById(id).orElse(null);

        if (existingOrder == null) {
            return null;
        }

        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setTotalAmount(order.getTotalAmount());
        existingOrder.setUser(order.getUser());
        existingOrder.setOrderItems(order.getOrderItems());

        return orderRepository.save(existingOrder);
    }

    // DELETE ORDER
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
        System.out.println("Order deleted successfully");
    }
}