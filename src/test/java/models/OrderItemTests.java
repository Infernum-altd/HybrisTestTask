package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderItemTests {
    @Test
    public void convertInputToOrderItemTest() {
        OrderItem orderItem = new OrderItem(1, 1);
        assertEquals(orderItem, OrderItem.convertInputToOrderItem("1 1"));
    }
}
