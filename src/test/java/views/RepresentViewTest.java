package views;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class RepresentViewTest {
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
    public void interactOptionOne() {
        sendIn("1");
        RepresentProductsView view = (RepresentProductsView) new RepresentView().interact();
        RepresentProductsView expected = new RepresentProductsView();
        assertEquals(view, expected);
    }

    @Test
    public void interactOptionTow() {
        sendIn("2");
        RepresentOrderedProductsView view = (RepresentOrderedProductsView) new RepresentView().interact();
        RepresentOrderedProductsView expected = new RepresentOrderedProductsView();
        assertEquals(view, expected);
    }

    @Test
    public void interactOptionThree() {
        sendIn("3");
        sendIn("back");
        RepresentView view = (RepresentView) new RepresentView().interact();
        RepresentView expected = new RepresentView();
        assertEquals(view, expected);
    }

    @Test
    public void interactOptionFour() {
        sendIn("4");
        RepresentOrdersView view = (RepresentOrdersView) new RepresentView().interact();
        RepresentOrdersView expected = new RepresentOrdersView(new ArrayList<>());
        assertEquals(view, expected);
    }

    @Test
    public void interactOptionFive() {
        sendIn("5");
        HomeView view = (HomeView) new RepresentView().interact();
        HomeView expected = new HomeView();
        assertEquals(view, expected);
    }

    @Test
    public void interactDefaultOption() {
        sendIn("sadsdffds");
        RepresentView expected = new RepresentView();
        RepresentView actual = (RepresentView) expected.interact();

        assertSame(actual, expected);
    }
}
