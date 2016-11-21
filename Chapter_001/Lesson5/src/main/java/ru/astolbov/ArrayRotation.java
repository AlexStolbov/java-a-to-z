package ru.astolbov;

/**
* ArrayRotation.
* @author astolbov
* @since 21.11.2016
*/

public class ArrayRotation {

	/**
	* Main.
	* Create array and rotate it.
	* @param args - args
	*/
	public static void main(String[] args) {
		final int arrayLength = 10;
		int[][] values = new int[arrayLength][arrayLength];

		for (int i = 0; i <= (values.length - 1); i++) {
			for (int j = 0; j <= (values[i].length - 1); j++) {
				values[i][j] = i;
			}
		}

		showArray(values);
		values = rotateArray(values);
		System.out.println("");
		showArray(values);
	}

	/**
	* Rotate a two-dimensional array by 90 degrees.
	* @param values - two-dimensional array
	* @return values - two-dimensional array, rotated by 90 degrees.
	*/
	public static int[][] rotateArray(int[][] values) {
		int arrayLength = values.length;
		int[][] valuesRotate = new int[arrayLength][arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			for (int j = 0; j < arrayLength; j++) {
				valuesRotate[j][arrayLength - 1 - i] = values[i][j];
			}
		}
		return valuesRotate;
	}

	/**
	* Type array in cosole.
	* @param arrayForShow - array that show
	*/
	public static void showArray(int[][] arrayForShow) {
		for (int[] elementI : arrayForShow) {
			for (int elementJ : elementI) {
				System.out.format("%d ", elementJ);
			}
			System.out.println("");
		}
	}
}
