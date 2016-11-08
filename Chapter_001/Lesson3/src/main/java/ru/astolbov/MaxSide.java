package ru.astolbov;

	/**
	*Class MaxSide
	* максимальная сторона треугольника
	*@author stolbov
	*@since 08.11.2016
	*/

public class MaxSide{

	public MaxSide() {
	}

	/**
	* Вычисляет максимальную сторону треугольника
	*@param triangle - объект класса Triangle
	*@return максимальная сторона треугольника
	*/
	public double max(Triangle triangle) {
		double side_ab = triangle.a.distanceTo(triangle.b);
		double side_ac = triangle.a.distanceTo(triangle.c);
		double side_bc = triangle.b.distanceTo(triangle.c);

		System.out.println("max side " + side_ab);

		double maxside = (side_ac >= side_ab) ? side_ac : side_ab;
		maxside = (maxside >= side_bc) ? maxside : side_bc;

		return maxside;
	}
}
	