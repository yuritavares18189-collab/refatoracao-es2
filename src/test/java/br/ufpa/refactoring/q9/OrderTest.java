package br.ufpa.refactoring.q9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void finalTotal_examples() {
        var vip = new Order.Customer(true, 6);
        var o1 = new Order(vip, 200.0, 0.10);
        assertEquals(140.0, o1.finalTotal(), 0.001);

        var regular = new Order.Customer(false, 1);
        var o2 = new Order(regular, 200.0, 0.10);
        assertEquals(180.0, o2.finalTotal(), 0.001);
    }

    @Test
    void refactorGoal_moveDiscountLogic_toCustomerOrPolicy() {
        // TODO: mover lógica de desconto para Customer ou um DiscountPolicy e fazer Order delegar.
    }
}
