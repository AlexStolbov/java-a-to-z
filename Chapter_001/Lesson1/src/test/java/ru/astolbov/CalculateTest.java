package ru.astolbov;

/**
	*Class CalculateTest тестирование класса Calculate
	*@author stolbov
	*@since 05.11.2016
*/

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateTest{
	@Test
	public void WhenSendStopInEchoThenReturnThreeStops(){
		Calculate calc = new Calculate();
		String result = calc.echo("stop");
		assertThat(result, is("stop stop stop"));
	}
}