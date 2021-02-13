package utils;

import static org.junit.Assert.*;

import org.junit.Test;
import utils.PropertyReader;

public class PropertyReaderTests {
    @Test
    public void getPropertyTest() {
        assertEquals("3306", PropertyReader.getProperty("dbport"));
    }
}
