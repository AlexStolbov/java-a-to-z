package ru.astolbov;

/**
* Turn.
* @author astolbov
* @since 22.11.2016
*/

public class Turn {

	/**
	* Turn the array.
	* @param values - one-dimensional array
	* @return values - one-dimensional array.
	*/
	public int[] back(int[] values) {
		int rigthPosition;
		int temp;
		int arrayLength = values.length;
		int finish = ((int) (arrayLength / 2));
		for (int leftPosition = 0; leftPosition < finish; leftPosition++) {
			temp = values[leftPosition];
			rigthPosition = arrayLength - 1 - leftPosition;
			values[leftPosition] = values[rigthPosition];
			values[rigthPosition] = temp;
			}
		return values;
	}
}
