package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
* Test class BubleSort.
*/

public class BubleSortTest {
	@Test
	public void whenSortArrayThenIsWell() {
		int[] arrayForSort = new int[] {5, 2, 8, 1, 7, 4, 9, 3, 6, 10};
		int[] arraySort = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		BubbleSort bSort = new BubbleSort();
		arrayForSort = bSort.sort(arrayForSort);
		assertThat(arrayForSort, is(arraySort));
	}

	@Test
	public void whenSortArrayWithOneElementThenItEqualsItself() {
		int[] arrayForSort = new int[] {5};
		int[] arraySort = new int[] {5};
		
		BubbleSort bSort = new BubbleSort();
		arrayForSort = bSort.sort(arrayForSort);
		assertThat(arrayForSort, is(arraySort));
	}

	@Test
	public void whenSortZeroArrayThenItEqualsItself() {
		int[] arrayForSort = new int[] {};
		int[] arraySort = new int[] {};
		
		BubbleSort bSort = new BubbleSort();
		arrayForSort = bSort.sort(arrayForSort);
		assertThat(arrayForSort, is(arraySort));
	}
}