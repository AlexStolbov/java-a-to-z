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
		double sideAB = triangle.geta().distanceTo(triangle.getb());
		double sideAC = triangle.geta().distanceTo(triangle.getc());
		double sideBC = triangle.getb().distanceTo(triangle.getc());

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
