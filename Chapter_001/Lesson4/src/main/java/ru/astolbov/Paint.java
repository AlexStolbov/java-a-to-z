package ru.astolbov;

/**
* Class Paint .
* Строит пирамиду пирамиды.
* @author astolbov
* @since 19.11.2016
*/

public class Paint {
	/**
	* Main.
	* @param args - args
	*/
	public static void main(String[] args) {
		Paint p = new Paint();
		String s = p.create(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
		System.out.print(s);
	}

	/**
	* Paint.
	* @param heightPyramide - height of pyramid
	* @param koeff - koeff = height/base, must be: 1, 2, 3...
	* @return - String containing pyramid
	*/

	public String create(int heightPyramide, int koeff) {

		/**
		* Top of pyramide.
		* делаем корректировку, т.к. система координат, в которой рисуем начинается не с 0, а с 1
		*/
		int topPyramideLeft = koeff * (heightPyramide + 1);
		int topPyramideRight = koeff * (heightPyramide - 1);

		/**
		* String containing pyramid
		*/
		StringBuilder pyramide = new StringBuilder();

		/**
		* Left side of pyramide
		*/
		int leftSide = 0;
		/**
		* Right side of pyramide
		*/
		int rightSide = 0;

		for (int x = 1; x <= heightPyramide; x++) {

			leftSide = topPyramideLeft - koeff * x;
			rightSide = topPyramideRight + koeff * x;
			for (int y = 1; y <= rightSide; y++) {
				if ((y == leftSide) || (y == rightSide)) {
					pyramide.append("^");
				} else {
					pyramide.append(" ");
				}
			}
			pyramide.append("\n");
		}
		return pyramide.toString();
	}
}
