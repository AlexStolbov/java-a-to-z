package ru.astolbov;

   /**
   * Class MaxSide.
   * максимальная сторона треугольника
   * @author stolbov
   * @since 08.11.2016
   */

public class MaxSide {
	/**
	* Вычисляет максимальную сторону треугольника.
	*@param triangle - объект класса Triangle
	*@return максимальная сторона треугольника
	*/

	public double max(Triangle triangle) {
		double sideAB = triangle.a.distanceTo(triangle.b);
		double sideAC = triangle.a.distanceTo(triangle.c);
		double sideBC = triangle.b.distanceTo(triangle.c);

		double maxside = sideAB;

		if (sideAC >= sideAB) {
			maxside = sideAC;
		}

		if (sideBC > maxside) {
			maxside = sideBC;
		}

		return maxside;
	}
}
