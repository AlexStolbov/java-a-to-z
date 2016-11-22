package ru.astolbov;

/**
* ArrayRotation.
* @author astolbov
* @since 21.11.2016
*/

public class ArrayRotation {

	/**
	* Rotate a two-dimensional array by 90 degrees.
	* @param values - two-dimensional array
	* @return values - two-dimensional array, rotated by 90 degrees.
	*/
	public int[][] rotateArray(int[][] values) {
		int arrayLength = values.length;
		int[][] valuesRotate = new int[arrayLength][arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			for (int j = 0; j < arrayLength; j++) {
				valuesRotate[j][arrayLength - 1 - i] = values[i][j];
			}
		}
		return valuesRotate;
	}
}
