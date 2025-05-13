package com.example.order.domain.listener;

import com.example.order.domain.event.OrderCreatedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {

    private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        reduceInventory(event);
    }

    private void reduceInventory(OrderCreatedEvent event) {
        event.getProducts().forEach(product -> {
            logger.info("Reduciendo stock del producto: {}", product);
        });
    }
}
