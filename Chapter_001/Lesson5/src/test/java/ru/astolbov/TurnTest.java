package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class Turn.
*/

public class TurnTest {
	/**
	* Test turn array.
	*/
	@Test
	public void whenSendArrayThenTutnArray() {
		//6 elementss
		int[] arrayForTest = new int[]{1, 2, 3, 4, 5, 6};
		int[] arrayTest = new int[]{6, 5, 4, 3, 2, 1};

		arrayForTest = new Turn().back(arrayForTest);

		assertThat(arrayForTest, is(arrayTest));

		//5 elementss
		arrayForTest = new int[]{1, 2, 3, 4, 5};
		arrayTest = new int[]{5, 4, 3, 2, 1};

		arrayForTest = new Turn().back(arrayForTest);

		assertThat(arrayForTest, is(arrayTest));
	}
}