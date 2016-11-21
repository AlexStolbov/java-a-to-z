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

		for (int i = 0; i <= (arrayForRotate.length - 1); i++) {
			for (int j = 0; j <= (arrayForRotate[i].length - 1); j++) {
				arrayForRotate[i][j] = i;
			}
		}

		arrayForRotate = ArrayRotation.rotateArray(arrayForRotate);

		assertThat(arrayForRotate, is(arrayTest));
	}
}