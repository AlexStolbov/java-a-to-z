package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Class CalculateTest тестирование класса Calculate.
 *@author stolbov
 *@since 05.11.2016
*/

public class CalculateTest {
	/**
	* Test.
	*/
	@Test
	public void whenSendStopInEchoThenReturnThreeStops() {
		Calculate calc = new Calculate();
		String result = calc.echo("stop");
		assertThat(result, is("stop stop stop"));
	}
}