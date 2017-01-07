package ru.astolbov.Start.Input;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by alex on 12/28/16.
 */
public class ConsoleInputTest {
    /**
     * Test console input.
     */
    @Test
    public void whenAskTestThenGeStringTest() {
        String testString = "SomeText";
        ByteArrayInputStream in = new ByteArrayInputStream(testString.concat(System.lineSeparator()).getBytes());
        System.setIn(in);
        ConsoleInput consoleInput = new ConsoleInput();
        String request = consoleInput.ask("test ask");
        assertThat(request, is(testString));
    }
}
