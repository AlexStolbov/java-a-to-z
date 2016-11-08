package ru.astolbov;

	/**
	*Class Point
	* точка в декартовой системе координат
	*@author stolbov
	*@since 08.11.2016
	*/

import java.lang.Math.*;

public class Point{
	/**
	*Абцисса
	*/
	public double x;
	/**
	*Ордината
	*/
	public double y;

	/**
	*Создание точки
	*@param x - абцисса
	*@param y - ордината
	*@return точка
	*/
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	*calculate distance between two points
	*@param point - точка до которй вычисляется расстояние
	*@return расстояние до заданной точки
	*/
	public double distanceTo(Point point) {
		return Math.sqrt(Math.pow((this.x - point.x), 2.0) + Math.pow((this.y - point.y), 2.0));
	}
}
	