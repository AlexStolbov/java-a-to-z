package ru.astolbov;

/**
* Class FactorialXalculate.
* Вызов класса Factorial.
* @author astolbov
* @since 12.11.2016
*/

public class FactorialCalculate {
	/**
	* Вычислить факториал от 0 до заданного числа
	*/
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("set the max value in command line");
		} else {
			Factorial factor = new Factorial();
			int finish = Integer.valueOf(args[0]);
			for (int i = 0; i <= finish; i++) {
				System.out.printf("for %1d factorial is %2d %n", i, factor.calculate(i));
			}
		}
	}
}
