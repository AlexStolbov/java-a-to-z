package ru.astolbov.Start.Input;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 1/31/17.
 */
public class ConsoleInputValidateTest {

    /**
     * Test validate input.
     */
    @Test
    public void whenAskInttCharThenReturnInt() {
        String question = "Select menu: ";
        int menuTestKey = 1;
        String testString = "a".concat(System.lineSeparator()).concat(String.valueOf(menuTestKey)).concat(System.lineSeparator());
        int maxMenuKey = 3;
        ByteArrayInputStream in = new ByteArrayInputStream(testString.getBytes());
        System.setIn(in);
        ConsoleInputValidate consoleInputValidate = new ConsoleInputValidate();
        int menuKey = consoleInputValidate.ask(question, maxMenuKey);
        assertThat(menuKey, is(menuTestKey));
    }

}