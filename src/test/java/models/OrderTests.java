package models;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderTests {
    private static Order order;

    @BeforeClass
    public static void setUp() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(1,2));
        orderItems.add(new OrderItem(2, 10));

        order = new Order();
        order.setId(1);
        order.setUserId(1);
        order.setStatus(OrderStatus.PREPARING);
        order.setCreatedAt(LocalDateTime.now());
        order.setOrderItems(orderItems);
    }

    @Test
    public void convertInputToOrderTest() {
        Order actual = Order.convertInputToOrder("1 10, 2 5");
        assertNotNull(actual);
    }

    @Test
    public void isInputForOrderMatchesTrueTest() {
        assertTrue(Order.isInputForOrderMatches("1 10, 2 5"));
    }

    @Test
    public void isInputForOrderMatchesFalseTest() {
        assertFalse(Order.isInputForOrderMatches("1 10, 2 5234, 23 4234  243 23"));
    }

    @Test
    public void calculateTotalItemsQuantityTest() {
        assertEquals(12, order.calculateTotalItemsQuantity());
    }

    @Test
    public void changeQuantityTest() {
        order.changeQuantity(1, 1);
        assertEquals(1, order.getOrderItems().get(0).getQuantity());
    }
}
