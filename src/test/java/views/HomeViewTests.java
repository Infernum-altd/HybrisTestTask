package views;

import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


import static org.junit.Assert.*;

public class HomeViewTests {
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
        sendIn("1" + System.lineSeparator());

        CreateView view = (CreateView) new HomeView().interact();
        CreateView expected = new CreateView();
        assertEquals(view, expected);
    }

    @Test
    public void interactOptionTwoTest() {
        sendIn("2" + System.lineSeparator());
        RemoveView view = (RemoveView) new HomeView().interact();
        RemoveView expected = new RemoveView();
        assertEquals(view, expected);
    }

    @Test
    public void interactOptionThreeTest() {
        sendIn("3" + System.lineSeparator());
        RepresentView view = (RepresentView) new HomeView().interact();
        RepresentView expected = new RepresentView();
        assertEquals(view, expected);
    }

    @Test
    public void interactOptionDefaultTest() {
        sendIn("asdasdsd" + System.lineSeparator());
        HomeView expected = new HomeView();
        HomeView actual = (HomeView) expected.interact();

        assertSame(actual, expected);
    }
}
