package ru.astolbov;

/**
*Class TriangleTest
* Тест классов Poin и Triangle
*@author stolbov
*@since 08.11.2016
*/

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.lang.Math.*;

public class TriangleTest{

	/**
	* Расстояние между двумя точками
	*/
	@Test
	public void WhenSendPointThenGetDistance(){
		double minX = 10.0;
		double minY = 10.0;
		
		double maxX = 20.0;
		double maxY = 20.0;

		double distance = Math.sqrt(200);

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
	public void WhenCalcAreaNotExistTriangleThenAreaEqualsZero(){
		Point pointFirst = new Point(1.0, 1.0);
		Point pointSecond = new Point(2.0, 2.0);
		final double AREA_ZERO = 0.0;
		final boolean TRIANGLE_NOT_EXIST = false;

		Triangle triangle = new Triangle(pointFirst, pointFirst, pointSecond);
		double area = triangle.calcarea();
		assertThat(area, is(AREA_ZERO));
		assertThat(triangle.TriangleExist(), is(TRIANGLE_NOT_EXIST));

		Triangle triangle2 = new Triangle(pointFirst, pointSecond, pointFirst);
		double area2 = triangle2.calcarea();
		assertThat(area2, is(AREA_ZERO));
		assertThat(triangle2.TriangleExist(), is(TRIANGLE_NOT_EXIST));

		Triangle triangle3 = new Triangle(pointSecond, pointFirst, pointFirst);
		double area3 = triangle3.calcarea();
		assertThat(area3, is(AREA_ZERO));
		assertThat(triangle3.TriangleExist(), is(TRIANGLE_NOT_EXIST));
	}

	/**
	* Площадь заданного треугольника
	*/
	public void WhenCalcAreaThenArea(){
		Point pointA = new Point(10.0, 10.0);
		Point pointB = new Point(22.0, 10.0);
		Point pointC = new Point(16.0, 20.0);
		final boolean TRIANGLE_NOT_EXIST = false;
		final boolean TRIANGLE_EXIST = true;

		double areaTest = Math.sqrt(236);

		Triangle triangle = new Triangle(pointA, pointB, pointC);
		double area = triangle.calcarea();
		assertThat(area, is(areaTest));
		assertThat(triangle.TriangleExist(), is(!TRIANGLE_NOT_EXIST));
		assertThat(triangle.TriangleExist(), is(TRIANGLE_EXIST));
	}
}