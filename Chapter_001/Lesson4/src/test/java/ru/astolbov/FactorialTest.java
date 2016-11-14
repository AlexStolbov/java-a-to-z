package ru.astolbov;

/**
*Class FactorialTest.
* Тест класса Square
*@author stolbov
*@since 12.11.2016
*/

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.math.*;

public class FactorialTest{

	/**
	* Факториал
	*/
	@Test
	public void whenCalcSquareThenGetWellResult(){
		final int TEST_NEGATIVE = -1;
		final int TEST_ZERO = 0;
		final int TEST_ONE = 1;
		final int TEST_TEN = 10;

		Factorial fac = new Factorial();
		
		assertThat(fac.calculate(TEST_NEGATIVE), is(BigInteger.valueOf(0)));
		assertThat(fac.calculate(TEST_ZERO), is(BigInteger.valueOf(1)));
		assertThat(fac.calculate(TEST_ONE), is(BigInteger.valueOf(1)));
		assertThat(fac.calculate(TEST_TEN), is(BigInteger.valueOf(3628800)));
	}
}