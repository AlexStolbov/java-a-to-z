package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class ArrayRotation.
*/

public class ArrayRotationTest {
	/**
	* Test rotate of array.
	*/
	@Test
	public void whenRotateArrayThenRotateWell() {
		final int arrayLength = 3;
		int[][] arrayTest = new int[arrayLength][arrayLength];
		arrayTest[0] = new int[]{2, 1, 0};
		arrayTest[1] = new int[]{2, 1, 0};
		arrayTest[2] = new int[]{2, 1, 0};

		int[][] arrayForRotate = new int[arrayLength][arrayLength];
		arrayForRotate[0] = new int[]{0, 0, 0};
		arrayForRotate[1] = new int[]{1, 1, 1};
		arrayForRotate[2] = new int[]{2, 2, 2};

		arrayForRotate = new ArrayRotation().rotateArray(arrayForRotate);

		assertThat(arrayForRotate, is(arrayTest));
	}
}