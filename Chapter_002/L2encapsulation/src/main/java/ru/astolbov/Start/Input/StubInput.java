package ru.astolbov.Start.Input;

/**
 * Created by alex on 12/21/16.
 */
public class StubInput implements Input {
    /**
     * Array of answers.
     */
    private String[] answers;
    /**
     * Number of last answer.
     */
    private int lastAnswer;

    /**
     * Constructor.
     * @param answersSet - set of answers
     */
    public StubInput(String[] answersSet) {
        this.answers = answersSet;
        this.lastAnswer = 0;
    }

    /**
     * Return next answer.
     * @param question - not use
     * @return String of answer
     */
    public String ask(String question) {
        int numberForReturn = this.lastAnswer;
        if (this.lastAnswer < this.answers.length - 1) {
            this.lastAnswer++;
        } else {
            lastAnswer = 0;
        }
        return this.answers[numberForReturn];
    }
}