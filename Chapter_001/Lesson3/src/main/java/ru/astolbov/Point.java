package ru.astolbov;

   /**
	* Class Point.
	* точка в декартовой системе координат
	* @author stolbov
	* @since 08.11.2016
	*/

public class Point {
   /**
	* Абцисса.
	*/
	private double x;
	/**
	*Ордината.
	*/
	private double y;

   /**
	* Получить абциссу точки
	* @return абцисса
	*/
	public double getX() {
		return this.x;
	}

	/**
	* Получить ординату точки.
	* @return ордината
	*/
	public double getY() {
		return this.y;
	}

   /**
	* Создание точки.
	* @param setx - абцисса
	* @param sety - ордината
	*/
	public Point(double setx, double sety) {
		this.x = setx;
		this.y = sety;
	}

   /**
	* calculate distance between two points.
	* @param point - точка до которй вычисляется расстояние
	* @return расстояние до заданной точки
	*/
	public double distanceTo(Point point) {
		double partone = Math.pow((this.x - point.x), 2.0);
		double parttwo = Math.pow((this.y - point.y), 2.0);
		return Math.sqrt(partone + parttwo);
	}
}
