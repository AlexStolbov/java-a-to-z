package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.math.BigInteger;

/**
*Class FactorialTest.
* Тест класса Square
*@author stolbov
*@since 12.11.2016
*/

public class FactorialTest {

	/**
	* Факториал.
	*/
	@Test
	public void whenCalcSquareThenGetWellResult() {
		final int TEST_NEGATIVE = -1;
		final int TEST_ZERO = 0;
		final int TEST_ONE = 1;
		final int TEST_TEN = 10;
		final int resForTen = 3628800;

		Factorial fac = new Factorial();

		assertThat(fac.calculate(TEST_NEGATIVE), is(BigInteger.valueOf(0)));
		assertThat(fac.calculate(TEST_ZERO), is(BigInteger.valueOf(1)));
		assertThat(fac.calculate(TEST_ONE), is(BigInteger.valueOf(1)));
		assertThat(fac.calculate(TEST_TEN), is(BigInteger.valueOf(resForTen)));
	}
}