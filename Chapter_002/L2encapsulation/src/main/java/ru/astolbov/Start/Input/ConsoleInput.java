package ru.astolbov.Start.Input;


import java.util.Scanner;

/**
 * Created by alex on 12/20/16.
 */
public class ConsoleInput implements Input {

    /**
     * Get users input.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Asks a question to the user and receives the response.
     * @param question - a question to the user
     * @return - the input string
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
