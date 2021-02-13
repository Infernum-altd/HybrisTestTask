package utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class ConsoleReadWriteTests {
    private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

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

    @After
    public void reloadOutStream() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void showErrorMessageTest() {
        ConsoleReadWrite.showErrorMessage("message");
        String actual = outContent.toString();
        assertEquals("\033[0;31mmessage\033[0m" + System.lineSeparator(), actual);
    }

    @Test
    public void showErrorMessageWithTimePauseTest() {
        ConsoleReadWrite.showErrorMessageWithTimePause("message");
        String actual = outContent.toString();
        assertEquals("\033[0;31mmessage\033[0m" + System.lineSeparator(), actual);
    }

    @Test
    public void showSuccessfulMessageWithTimePauseTest() {
        ConsoleReadWrite.showSuccessfulMessageWithTimePause("message");
        String actual = outContent.toString();
        assertEquals("\033[0;32mmessage\033[0m" + System.lineSeparator(), actual);
    }

    @Test
    public void showSuccessfulMessageTest() {
        ConsoleReadWrite.showSuccessfulMessage("message");
        String actual = outContent.toString();
        assertEquals("\033[0;32mmessage\033[0m" + System.lineSeparator(), actual);
    }

    @Test
    public void readConsoleInputTest() {
        sendIn("message");
        String actual = ConsoleReadWrite.readConsoleInput();
        assertEquals(actual, "message");
    }
}
