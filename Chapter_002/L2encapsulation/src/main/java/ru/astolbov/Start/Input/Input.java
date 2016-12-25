package ru.astolbov.Start.Input;

/**
 * Created by alex on 12/20/16.
 */
public interface Input {

    /**
     * Asks a question to the user and receives the response.
     * @param question - a question to the user
     * @return - the input string
     */
    String ask(String question);
}
