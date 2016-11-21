package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class DuplicatesRemove.
*/

public class DuplicatesRemoveTest {
	/**
	* Test remove duplicates from array.
	*/
	@Test
	public void whenSendArrayThenRemoveDuplicates() {
		String[] country = new String[]{"Russia", "USA", "China", "USA", "France", "China", "Russia", "USA", "France"};
		String[] countryTest = new String[]{"Russia", "USA", "China", "France"};

		country = DuplicatesRemove.removeDuplicates(country);

		assertThat(country, is(countryTest));
	}
}