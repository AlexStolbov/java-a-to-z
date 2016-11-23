package ru.astolbov;

/**
* Rearrange array.
*/

public class Rearrange {

	/**
	* Output array.
	* Содержит варианты перестановок.
	*/
	private int[][] arrayResult;

	/**
	* Start position.
	*/
	private int posInsert;


	/**
	* Get output array.
	* @return - return output array
	*/
	public int[][] getOutputArray() {
		return this.arrayResult;
	}

	/**
	* Starts the search for permutations.
	* @param origin - limit
	*/
	public void rearrangeStart(int[] origin) {
		this.arrayResult = new int[this.factorial(origin.length)][origin.length];
		if (origin.length == 1) {
			this.arrayResult[0] = origin.clone();
		} else {
			this.posInsert = 0;
			this.rearrangeOneStep(origin, 0);
		}
	}

	/**
	* Recursive method.
	* @param arrayStep - limit
	* @param posShift - limit
	*/
	public void rearrangeOneStep(int[] arrayStep, int posShift) {
		for (int i = posShift; i <= arrayStep.length - 1; i++) {
			arrayStep = this.shift(arrayStep, posShift);
			if (posShift == arrayStep.length - 2) {
				this.arrayResult[this.posInsert] = arrayStep.clone();
				this.posInsert++;
			} else {
				this.rearrangeOneStep(arrayStep.clone(), posShift + 1);
			}
		}
	}

	/**
	* Shifts the array elements to the left.
	* example ({1, 2, 3, 4}, 0) --> {2, 3, 4, 1}
	* example ({1, 2, 3, 4}, 2) --> {1, 2, 4, 3}
	* @param arrayForShift - array
	* @param posShift - start position
	* @return - array
	*/
	public int[] shift(int[] arrayForShift, int posShift) {
		int leftElement = arrayForShift[posShift];

		for (int i = posShift + 1; i < arrayForShift.length; ++i) {
			arrayForShift[i - 1] = arrayForShift[i];
		}

		arrayForShift[arrayForShift.length - 1] = leftElement;
		return arrayForShift;
	}

	/**
	* Factorial.
	* @param limit - limit
	* @return - factorial
	*/
	public int factorial(int limit) {
		if (limit == 0) {
			return 1;
		} else {
			return limit * this.factorial(limit - 1);
		}
	}
}
