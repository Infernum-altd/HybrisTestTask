package views;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CreateOrderViewTests {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private static final PrintStream originalOut = System.out;
    private static final InputStream originalIn = System.in;

    @BeforeClass
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    public static void sendIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterClass
    public static void restoreSystemInputOutput() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void interactElseBranchTest() {
        sendIn("wrong input");
        CreateOrderView expected = new CreateOrderView();
        CreateOrderView actual = (CreateOrderView) expected.interact();
        assertEquals(actual, expected);
    }
}
