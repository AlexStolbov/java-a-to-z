package ru.astolbov.Start.Input;

import ru.astolbov.Start.StartUI;

/**
 * Created by alex on 12/21/16.
 */
public class StubInputMenu implements Input {
    /**
     * Array of answers.
     */
    private final String[] answers = new String[10];
    /**
     * Number of last answer.
     */
    private int lastAnswer;

    /**
     * Constructor.
     */
    public StubInputMenu() {
        for (int i = 0; i < new StartUI(null).getMenu().length; i++) {
            this.answers[i] = Integer.toString(i + 1);
        }
        this.lastAnswer = 0;
    }

    /**
     * Return next answer.
     * @param question - not use
     * @return String of answer
     */
    public String ask(String question) {
        int nuberFoReturn = this.lastAnswer;
        if (this.lastAnswer < this.answers.length - 1) {
            this.lastAnswer++;
        } else {
            lastAnswer = 0;
        }
        return this.answers[nuberFoReturn];
    }
}