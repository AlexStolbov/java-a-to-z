package ru.astolbov;

/**
*Class SquareTest.
* Тест класса Square
*@author stolbov
*@since 11.11.2016
*/

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareTest{

	/**
	* Расстояние между двумя точками
	*/
	@Test
	public void WhenCalcSquareThenGetWellResult(){
		final int COEFF_A = 10;
		final int COEFF_B = 15;
		final int COEFF_C = 20;

		Square square = new Square(COEFF_A, COEFF_B, COEFF_C);
		int x = 1;
		double y = 45;
		assertThat(square.calculate(x), is(y));
		x = 14;
		y = 2190;
		assertThat(square.calculate(x), is(y));
	}
}