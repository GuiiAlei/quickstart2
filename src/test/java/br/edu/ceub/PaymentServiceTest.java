package br.edu.ceub;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    void processPayment_order_250_pays_250_should_return_true() {
        //Preparar
        List<OrderItem> items = List.of(
                new OrderItem("Produto A", 60.0, 1),
                new OrderItem("Produto B", 50.0, 2),
                new OrderItem("Produto C", 30.0, 3)
        );
        Order order = new Order("ORD123", items);

        PaymentService paymentService = new PaymentService();

        //Executar
        Boolean result = paymentService.processPayment(order, 250);

        //Verificar
        assertTrue(result);
    }

    @Test
    void processPayment_order_250_pays_240_should_return_false() {
        //Preparar
        List<OrderItem> items = List.of(
                new OrderItem("Produto A", 60.0, 1),
                new OrderItem("Produto B", 50.0, 2),
                new OrderItem("Produto C", 30.0, 3)
        );
        Order order = new Order("ORD123", items);

        PaymentService paymentService = new PaymentService();

        //Executar
        Boolean result = paymentService.processPayment(order, 240);

        //Verificar
        assertFalse(result);
    }
}