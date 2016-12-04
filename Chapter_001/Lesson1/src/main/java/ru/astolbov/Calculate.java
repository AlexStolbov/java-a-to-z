package ru.astolbov;

/**
 * Class Calculate решение задачи части 001 урок1.
 *
 * @author stolbov
 * @since 05.11.2016
 */

public class Calculate {
    /**
     * Конструктор, вывод строки в консоль.
     * @param args - args
     */

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * Метод для тестирования.
     *
     * @param value - строка для вывода в консоль
     * @return - echo for param
     */

    public String echo(String value) {
        return String.format("%s %s %s", value, value, value);
    }
}