package br.edu.ceub;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {
    PaymentService paymentService;
    Order order;
    @BeforeEach
   void setUp() {
        paymentService = new PaymentService();
        List<OrderItem> items = List.of(
                new OrderItem("Produto A", 60.0, 1),
                new OrderItem("Produto B", 50.0, 2),
                new OrderItem("Produto C", 30.0, 3)
        );
        order = new Order("ORD123", items);

    }


    @Test
    void processPayment_order_250_pays_250_should_return_true() {
        //Preparar
        int amount = 250;

        //Executar
        Boolean result = paymentService.processPayment(order, 250);

        //Verificar
        assertTrue(result);
    }

    @Test
    void processPayment_order_250_pays_240_should_return_false() {
        //Preparar
        int amount = 240;

        //Executar
        Boolean result = paymentService.processPayment(order, 240);

        //Verificar
        assertFalse(result);
    }
}