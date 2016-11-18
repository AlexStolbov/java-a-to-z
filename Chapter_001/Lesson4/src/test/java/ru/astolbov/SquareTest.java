package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Class SquareTest.
* Тест класса Square
*@author stolbov
*@since 11.11.2016
*/

public class SquareTest {

	/**
	* Расстояние между двумя точками.
	*/
	@Test
	public void whenCalcSquareThenGetWellResult() {
		final int COEFF_A = 10;
		final int COEFF_B = 15;
		final int COEFF_C = 20;
		final int xFirst = 1;
		final double yFirst = 45;
		final int xSecond = 14;
		final double ySecond = 2190;

		Square square = new Square(COEFF_A, COEFF_B, COEFF_C);

		assertThat(square.calculate(xFirst), is(yFirst));
		assertThat(square.calculate(xSecond), is(ySecond));
	}
}