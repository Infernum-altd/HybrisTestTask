package models;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

public class ProductTests {
    @Test
    public void createProductFromInputTest() {
        LocalDateTime time = LocalDateTime.now();
        Product expected = new Product("name",10,ProductStatus.IN_STOCK, time);
        Product actual = Product.createProductFromInput("name 10 2");
        actual.setCreatedAt(time);
        assertEquals(expected, actual);
    }
}
