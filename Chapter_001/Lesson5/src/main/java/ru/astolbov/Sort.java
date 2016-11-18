package ru.astolbov;

/**
* BubbleSort.
* Call class BubbleSort.
* @author astolbov
* @since 16.11.2016
*/

public class Sort {

	/**
	* Create array and sort it.
	* @param args - args
	*/
	public static void main(String[] args) {
		int[] arrayForSort = new int[] {5, 2, 8, 1, 7, 4, 9, 3, 6, 10};
		System.out.println("No sorted array");
		showArray(arrayForSort);
		BubbleSort bSort = new BubbleSort();
		arrayForSort = bSort.sort(arrayForSort);
		System.out.println("Sorted array");
		showArray(arrayForSort);
	}

	/**
	* Type array in cosole.
	* @param arrayForShow - array that show
	*/
	public static void showArray(int[] arrayForShow) {
		for (int element : arrayForShow) {
			System.out.println(element);
		}
	}
}
