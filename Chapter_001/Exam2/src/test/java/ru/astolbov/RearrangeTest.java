package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Calass Rearrange.
* @author astolbov
* @since 23.11.2016
*/

public class RearrangeTest {

	/**
	* Test for [1].
	*/

	@Test
	public void whenRearrange1ThenRearrangeWell() {

		int[] arrayOrigin = new int[]{1};
		int[][] arrayWell = new int[1][];
		arrayWell[0] = new int[]{1};

		Rearrange rear = new Rearrange();
		rear.rearrangeStart(arrayOrigin);
		int[][] arrayTest = rear.getOutputArray();

		assertThat(arrayTest, is(arrayWell));
	}


	/**
	* Test for [2].
	*/

	@Test
	public void whenRearrange2ThenRearrangeWell() {

		int[] arrayOrigin = new int[]{1, 2};
		int[][] arrayWell = new int[2][];
		arrayWell[0] = new int[]{2, 1};
		arrayWell[1] = new int[]{1, 2};

		Rearrange rear = new Rearrange();
		rear.rearrangeStart(arrayOrigin);
		int[][] arrayTest = rear.getOutputArray();

		assertThat(arrayTest, is(arrayWell));
	}

	/**
	* Test for [3].
	*/

	@Test
	public void whenRearrange3ThenRearrangeWell() {

		int[] arrayOrigin = new int[]{1, 2, 3};
		int[][] arrayWell = new int[6][];
		arrayWell[0] = new int[]{2, 1, 3};
		arrayWell[1] = new int[]{2, 3, 1};
		arrayWell[2] = new int[]{3, 2, 1};
		arrayWell[3] = new int[]{3, 1, 2};
		arrayWell[4] = new int[]{1, 3, 2};
		arrayWell[5] = new int[]{1, 2, 3};

		Rearrange rear = new Rearrange();
		rear.rearrangeStart(arrayOrigin);
		int[][] arrayTest = rear.getOutputArray();

		assertThat(arrayTest, is(arrayWell));
	}

	/**
	* Test for [4] array.
	*/
	@Test
	public void whenRearrange4ThenRearrangeWell() {

		int[] arrayOrigin = new int[]{1, 2, 3, 4};
		int[][] arrayWell = new int[24][];
		arrayWell[0] = new int[]{2, 4, 3, 1};
		arrayWell[1] = new int[]{2, 4, 1, 3};
		arrayWell[2] = new int[]{2, 1, 4, 3};
		arrayWell[3] = new int[]{2, 1, 3, 4};
		arrayWell[4] = new int[]{2, 3, 1, 4};
		arrayWell[5] = new int[]{2, 3, 4, 1};
		arrayWell[6] = new int[]{3, 1, 4, 2};
		arrayWell[7] = new int[]{3, 1, 2, 4};
		arrayWell[8] = new int[]{3, 2, 1, 4};
		arrayWell[9] = new int[]{3, 2, 4, 1};
		arrayWell[10] = new int[]{3, 4, 2, 1};
		arrayWell[11] = new int[]{3, 4, 1, 2};
		arrayWell[12] = new int[]{4, 2, 1, 3};
		arrayWell[13] = new int[]{4, 2, 3, 1};
		arrayWell[14] = new int[]{4, 3, 2, 1};
		arrayWell[15] = new int[]{4, 3, 1, 2};
		arrayWell[16] = new int[]{4, 1, 3, 2};
		arrayWell[17] = new int[]{4, 1, 2, 3};
		arrayWell[18] = new int[]{1, 3, 2, 4};
		arrayWell[19] = new int[]{1, 3, 4, 2};
		arrayWell[20] = new int[]{1, 4, 3, 2};
		arrayWell[21] = new int[]{1, 4, 2, 3};
		arrayWell[22] = new int[]{1, 2, 4, 3};
		arrayWell[23] = new int[]{1, 2, 3, 4};

		Rearrange rear = new Rearrange();
		rear.rearrangeStart(arrayOrigin);
		int[][] arrayTest = rear.getOutputArray();

		assertThat(arrayTest, is(arrayWell));
	}
}
