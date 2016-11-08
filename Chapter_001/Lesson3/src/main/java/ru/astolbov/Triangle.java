package ru.astolbov;

import java.lang.Math.*;

	/**
	*Class Triangle
	* Треугольник в декартовой системе координат
	*@author stolbov
	*@since 08.11.2016
	*/

public class Triangle{
	public Point a;
	public Point b;
	public Point c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	*Проверяет возможность построить треугольник через заданные точки.
	*Будем считать случай с точками на одной прямой - вырожденным треугольником
	*, иначе добавить код проверки принадлежности точек прямой в этот-же метод
	*/
	public boolean TriangleExist(){
		return !((a.equals(b) || a.equals(c) || b.equals(c)));
	}

	/**
	*Calculate the triangle area
	*@return площадь треугольника
	*/
	public double calcarea() {
		double area;
		if (TriangleExist()){
			double side_a_b = a.distanceTo(b);
			double side_a_c = a.distanceTo(c);
			double side_b_c = b.distanceTo(c);
			double p = side_a_b + side_a_b + side_b_c;
			area = Math.sqrt(p*(p - side_a_b)*(p - side_a_c)*(p - side_b_c));
		}else{			
			area = 0;
		}

		return area;
	}
}