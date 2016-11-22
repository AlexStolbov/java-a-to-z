package ru.astolbov;

import java.util.Arrays;

/**
* DuplicatesRemove.
* @author astolbov
* @since 21.11.2016
*/

public class DuplicatesRemove {

	/**
	* Main.
	* Creates an array and calls the method to remove duplicates
	* @param args - args
	*/
	public static void main(String[] args) {
		String[] country = new String[]{"France", "France", "Russia", "USA", "China", "USA", "France", "China", "Russia", "USA", "France"};

		showArray(country);
		System.out.println(country.length);

		country = removeDuplicates(country);
		
		showArray(country);
		System.out.println(country.length);
	}

	/**
	* Removes duplicates from array.
	* @param values - String array
	* @return values - String array without duplicates.
	*/
	public static String[] removeDuplicates(String[] values) {

		boolean copyElement;
		int lastElement = 1;

		for (int i = 1; i < values.length; i++) {
			copyElement = true;
			for (int j = 0; j < lastElement; j++) {
				if (values[i] == values[j]) {
					copyElement = false;
				}
			}
			if (copyElement) {
				values[lastElement] = values[i];
				lastElement++;
			}
		}

		return Arrays.copyOf(values, lastElement);
	}


	/**
	* Type array in cosole.
	* @param arrayForShow - array that show
	*/
	public static void showArray(String[] arrayForShow) {
		for (String element : arrayForShow) {
				System.out.printf("%s ", element);
		}
		System.out.println("");
	}
}
