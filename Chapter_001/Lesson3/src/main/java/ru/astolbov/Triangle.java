package ru.astolbov;

   /**
	* Class Triangl.
	* Треугольник в декартовой системе координат
	* @author stolbov
	* @since 08.11.2016
	*/

public class Triangle {
	/**
	* the "a" top of the triangle.
	*/
	private Point a;
	/**
	* the "b" top of the triangle.
	*/
	private Point b;
	/**
	* the "c" top of the triangle.
	*/
	private Point c;

	/**
	* Create class.
	* @param seta - the "a" top of the triangle
	* @param setb - the "b" top of the triangle
	* @param setc - the "c" top of the triangle
	*/

	public Triangle(Point seta, Point setb, Point setc) {
		this.a = seta;
		this.b = setb;
		this.c = setc;
	}

	/**
	* Get "a" top of the triangle.
	* @return "a" top of the triangle.
	*/
	public Point geta() {
		return this.a;
	}

	/**
	* Get "b" top of the triangle.
	* @return "b" top of the triangle.
	*/
	public Point getb() {
		return this.b;
	}

	/**
	* Get "c" top of the triangle.
	* @return "c" top of the triangle.
	*/
	public Point getc() {
		return this.c;
	}

   /**
	* Проверяет возможность построить треугольник через заданные точки.
	* Будем считать случай с точками на одной
	* прямой - вырожденным треугольником
	* , иначе добавить код проверки принадлежности точек
	* прямой в этот-же метод
	* @return true - треугольник существует, false - треугольник по
	* заданным точкам построить невозможно
	*/
	public boolean triangleexist() {
		return !((a.equals(b) || a.equals(c) || b.equals(c)));
	}

   /**
	* Calculate the triangle area.
	* @return площадь треугольника
	*/
	public double calcarea() {
		double area;
		if (triangleexist()) {
			double sideAB = a.distanceTo(b);
			double sideAC = a.distanceTo(c);
			double sideBC = b.distanceTo(c);
			double p = sideAB + sideAC + sideBC;
			area = Math.sqrt(p * (p - sideAB) * (p - sideAC) * (p - sideBC));
		} else {
			area = 0;
		}

		return area;
	}
}
