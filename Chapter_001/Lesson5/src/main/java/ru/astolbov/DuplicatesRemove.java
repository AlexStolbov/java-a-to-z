package ru.astolbov;

import java.util.Arrays;

/**
* DuplicatesRemove.
* @author astolbov
* @since 21.11.2016
*/

public class DuplicatesRemove {

	/**
	* Removes duplicates from array.
	* @param values - String array
	* @return values - String array without duplicates.
	*/
	public String[] removeDuplicates(String[] values) {

		boolean duplicatesFind;
		int lastElement = 1;
		int j;

		for (int i = 1; i < values.length; i++) {
			duplicatesFind = false;
			j = 0;
			do {
				duplicatesFind = values[i].equals(values[j]);
				j++;
			} while (!duplicatesFind & (j < lastElement));

			if (!duplicatesFind) {
				values[lastElement] = values[i];
				lastElement++;
			}
		}
		return Arrays.copyOf(values, lastElement);
	}
}
