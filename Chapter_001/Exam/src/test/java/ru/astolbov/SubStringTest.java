package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Calass SubString.
* @author astolbov
* @since 22.11.2016
*/

public class SubStringTest {

	/**
	* Test find sustring.
	*/
	@Test
	public void whenSendSubstringThenGetTrue() {

		String origin = "FindMeTest";
		String sub = "MeT";

		boolean resultTrue = new SubString().contains(origin, sub);

		assertThat(resultTrue, is(true));
	}

	/**
	* Test find no sustring.
	*/
	@Test
	public void whenSendNoSubstringThenGetFalse() {

		String origin = "FindMeTest";
		String noSub = "Med";

		boolean resultFalse = new SubString().contains(origin, noSub);

		assertThat(resultFalse, is(false));
	}
}
