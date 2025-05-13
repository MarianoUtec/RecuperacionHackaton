package com.example.order.domain.listener;

import com.example.order.domain.event.OrderCreatedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {

    private static final Logger logger = LogManager.getLogger(AuditLogListener.class);

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        logOrderAudit(event);
    }

    private void logOrderAudit(OrderCreatedEvent event) {
        logger.info("Registrando auditoría del pedido:\n - ID: {}\n - Email: {}\n - Productos: {}",
                event.getOrderId(),
                event.getEmail(),
                event.getProducts());
    }
}
