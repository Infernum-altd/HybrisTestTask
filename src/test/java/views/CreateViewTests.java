package views;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CreateViewTests {
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
    public void interactOptionOneTest() {
        sendIn("1");
        CreateProductView view = (CreateProductView) new CreateView().interact();
        CreateProductView expected = new CreateProductView();
        assertEquals(view, expected);
    }

    @Test
    public void interactOptionTwoTest() {
        sendIn("2");
        CreateOrderView view = (CreateOrderView) new CreateView().interact();
        CreateOrderView expected = new CreateOrderView();
        assertEquals(view, expected);
    }

    @Test
    public void interactOptionThreeTest() {
        sendIn("3");
        HomeView view = (HomeView) new CreateView().interact();
        HomeView expected = new HomeView();
        assertEquals(view, expected);
    }

    @Test
    public void interactOptionDefaultTest() {
        sendIn("asdasdsd");
        CreateView expected = new CreateView();
        CreateView actual = (CreateView) expected.interact();

        assertSame(actual, expected);
    }
}
