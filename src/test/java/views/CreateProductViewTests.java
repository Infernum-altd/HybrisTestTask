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

public class CreateProductViewTests {
    public static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public static final PrintStream originalOut = System.out;
    public static final InputStream originalIn = System.in;

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
    public void interactBackOption() {
        sendIn("back");
        CreateView view = (CreateView) new CreateProductView().interact();
        CreateView expected = new CreateView();
        assertEquals(view, expected);
    }

    @Test
    public void interactHomeOption() {
        sendIn("home");
        HomeView view = (HomeView) new CreateProductView().interact();
        HomeView expected = new HomeView();
        assertEquals(view, expected);
    }

    @Test
    public void interactDefaultOption() {
        sendIn("sadsdffds");
        CreateProductView expected = new CreateProductView();
        CreateProductView actual = (CreateProductView) expected.interact();

        assertSame(actual, expected);
    }

    @Test
    public void interactIfCaseOption() {
        sendIn("test 0 1");
        CreateProductView expected = new CreateProductView();
        CreateProductView actual = (CreateProductView) expected.interact();

        assertSame(actual, expected);
    }
}
