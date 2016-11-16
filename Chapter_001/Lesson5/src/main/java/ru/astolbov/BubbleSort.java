package ru.astolbov;

/**
* Class BubbleSort.
* Sort array by bubble.
* @author astolbov
* @since 14.11.2016
*/

public class BubbleSort {

	/**
	* Sort array by bubble.
	* @param values an array which is sorted
	* @return sorted array
	*/
	public int[] sort(int[] values) {
		boolean nextStep;
		int change;
		int lenghtArray = values.length;

		if (lenghtArray > 0) {
			do {
				nextStep = false;
				for (int i = 0; i < (lenghtArray - 1); i++) {
					if (values[i] > values[i + 1]) {
						change = values[i];
						values[i] = values[i + 1];
						values[i + 1] = change;
						nextStep = true;
					}
				}
			} while (nextStep);
		}
		return values;
	}
}
