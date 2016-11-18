package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Class TriangleTest.
* Тест классов Poin и Triangle
*@author stolbov
*@since 08.11.2016
*/

public class TriangleTest {

	/**
	* Расстояние между двумя точками.
	*/
	@Test
	public void whenSendPointThenGetDistance() {
		final double minX = 10.0;
		final double minY = 10.0;

		final double maxX = 16.0;
		final double maxY = 40.0;

		final double distance = Math.sqrt(936);

		Point pointFirst = new Point(minX, minY);
		Point pointSecond = new Point(maxX, maxY);
		double distanseFirstToSecond = pointFirst.distanceTo(pointSecond);
		double distanseSecondToFirst = pointSecond.distanceTo(pointFirst);
		assertThat(distanseFirstToSecond, is(distanseSecondToFirst));
		assertThat(distanseFirstToSecond, is(distance));
	}


	/**
	* Треугольник с сопадающими вершинами не существует
	* Площадь "несуществующего" треугольника, у которого вершины совпадают.
	*/
	@Test
	public void whenCalcAreaNotExistTriangleThenAreaEqualsZero() {
		Point pointFirst = new Point(1.0, 1.0);
		Point pointSecond = new Point(2.0, 2.0);
		final double AREA_ZERO = 0.0;
		final boolean TRIANGLE_NOT_EXIST = false;

		Triangle triangle = new Triangle(pointFirst, pointFirst, pointSecond);
		double area = triangle.calcarea();
		assertThat(area, is(AREA_ZERO));
		assertThat(triangle.triangleexist(), is(TRIANGLE_NOT_EXIST));

		Triangle triangle2 = new Triangle(pointFirst, pointSecond, pointFirst);
		double area2 = triangle2.calcarea();
		assertThat(area2, is(AREA_ZERO));
		assertThat(triangle2.triangleexist(), is(TRIANGLE_NOT_EXIST));

		Triangle triangle3 = new Triangle(pointSecond, pointFirst, pointFirst);
		double area3 = triangle3.calcarea();
		assertThat(area3, is(AREA_ZERO));
		assertThat(triangle3.triangleexist(), is(TRIANGLE_NOT_EXIST));
	}

	/**
	* Площадь заданного треугольника.
	*/
	@Test
	public void whenCalcAreaThenArea() {
		final double ten = 10.0;
		final double twentyTwo = 10.0;
		final double sixteen = 16.0;
		final double forty = 40;
		Point pointA = new Point(ten, ten);
		Point pointB = new Point(twentyTwo, ten);
		Point pointC = new Point(sixteen, forty);
		final boolean TRIANGLE_NOT_EXIST = false;
		final boolean TRIANGLE_EXIST = true;

		final double areaTest = 1872.0000000000002;

		Triangle triangle = new Triangle(pointA, pointB, pointC);
		double area = triangle.calcarea();
		assertThat(area, is(areaTest));
		assertThat(triangle.triangleexist(), is(!TRIANGLE_NOT_EXIST));
		assertThat(triangle.triangleexist(), is(TRIANGLE_EXIST));
	}

	/**
	* Максимальная сторона заданного треугольника.
	*/
	@Test
	public void whenMaxSideThenMaxSide() {
		final double ten = 10.0;
		final double twentyTwo = 10.0;
		final double sixteen = 16.0;
		final double forty = 40;
		Point pointA = new Point(ten, ten);
		Point pointB = new Point(twentyTwo, ten);
		Point pointC = new Point(sixteen, forty);

		final double maxsidetriangle = Math.sqrt(936);

		Triangle triangle = new Triangle(pointA, pointB, pointC);
		MaxSide maxside = new MaxSide();
		assertThat(maxside.max(triangle), is(maxsidetriangle));
	}
}