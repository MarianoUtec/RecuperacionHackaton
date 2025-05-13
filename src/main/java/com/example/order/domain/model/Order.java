package com.example.order.domain.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String id;

    private String email;

    @ElementCollection
    private List<String> products;

    @PrePersist
    public void ensureId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public Order() {}

    public Order(String id, String email, List<String> products) {
        this.id = id;
        this.email = email;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getProducts() {
        return products;
    }
}
