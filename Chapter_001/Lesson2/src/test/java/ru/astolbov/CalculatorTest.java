package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class CalculatorTest для тестирования класса Calculator.
* @author astolbov
* @since 07.11.2016
*/

public class CalculatorTest {

	/**
	* Testing class.
	*/
	private Calculator calc = new Calculator();

	/**
	* Test summ.
	*/

	@Test
	public void whenSendAddThenSumm() {
		final int val1 = 10;
		final int val2 = 2;
		final double res = 12;
		calc.add(val1, val2);
		assertThat(calc.getResult(), is(res));
	}

	/**
	* Test substraction.
	*/

	@Test
	public void whenSendSubtractionThenSubtraction() {
		final int val1 = 10;
		final int val2 = 2;
		final double res = 8.0;
		calc.subtraction(val1, val2);
		assertThat(calc.getResult(), is(res));
	}

	/**
	* Test div.
	*/

	@Test
	public void whenSendDivThenDiv() {
		final int val1 = 10;
		final int val2 = 2;
		final double res = 5.0;
		calc.div(val1, val2);
		assertThat(calc.getResult(), is(res));
	}

	/**
	* Test multiplication.
	*/

	@Test
	public void whenSendMultiplicationThenMultiplication() {
		final int val1 = 10;
		final int val2 = 2;
		final double res = 20.0;
		calc.multiplication(val1, val2);
		assertThat(calc.getResult(), is(res));
	}
}