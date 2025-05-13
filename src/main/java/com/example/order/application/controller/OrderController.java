package com.example.order.application.controller;

import com.example.order.domain.event.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public String createOrder(@RequestBody Map<String, Object> payload) {
        String orderId = (String) payload.get("orderId");
        String email = (String) payload.get("email");
        List<String> products = (List<String>) payload.get("products");

        OrderCreatedEvent event = new OrderCreatedEvent(this, orderId, email, products);
        publisher.publishEvent(event);

        return "Pedido recibido y evento publicado";
    }
}
