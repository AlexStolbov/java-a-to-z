package ru.astolbov;

/**
* Class SquareCalculate.
* Создание и вызов вычисления квадратного уровнения.
* @author astolbov
* @since 11.11.2016
*/

public class SquareCalculate {

	/**
	* Main.
	* calls class Square
	* @param args - args
	*/

	public static void main(String[] args) {
		/**
		* coeff a
		*/
		final int COEFF_A = 10;
		final int COEFF_B = 15;
		final int COEFF_C = 20;
		final int START_X = 20;
		final int FINISH_X = 20;
		final int STEP_X = 20;

		System.out.printf("a = %1d; b = %2d; c = %3d %n", COEFF_A, COEFF_B, COEFF_C);
		Square square = new Square(COEFF_A, COEFF_B, COEFF_C);
		square.show(START_X, FINISH_X, STEP_X);
	}
}
