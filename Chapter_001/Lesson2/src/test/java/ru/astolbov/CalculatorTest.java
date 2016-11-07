package ru.astolbov;

	/**
	*Class CalculatorTest для тестирования класса Calculator
	*@author astolbov
	*@since 07.11.2016
	*/

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest{
	
	private Calculator calc = new Calculator();

	@Test
	public void WhenSendAddThenSumm(){
		int val1 = 10;
		int val2 = 2;
		calc.add(val1, val2);
		assertThat(calc.getResult(), is(12.0));
	}

	@Test
	public void WhenSendSubtractionThenSubtraction(){
		int val1 = 10;
		int val2 = 2;
		calc.subtraction(val1, val2);
		assertThat(calc.getResult(), is(8.0));
	}

	@Test
	public void WhenSendDivThenDiv(){
		int val1 = 10;
		int val2 = 2;
		calc.div(val1, val2);
		assertThat(calc.getResult(), is(5.0));
	}

	@Test
	public void WhenSendMultiplicationThenMultiplication(){
		int val1 = 10;
		int val2 = 2;
		calc.multiplication(val1, val2);
		assertThat(calc.getResult(), is(20.0));
	}
}