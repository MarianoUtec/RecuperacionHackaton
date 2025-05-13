package com.example.order.domain.event;

import org.springframework.context.ApplicationEvent;
import java.util.List;

public class OrderCreatedEvent extends ApplicationEvent {

    private final String orderId;
    private final String email;
    private final List<String> products;

    public OrderCreatedEvent(Object source, String orderId, String email, List<String> products) {
        super(source);
        this.orderId = orderId;
        this.email = email;
        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getProducts() {
        return products;
    }
}
