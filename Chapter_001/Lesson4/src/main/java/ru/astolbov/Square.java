package ru.astolbov;

/**
* Class Square.
* Вычисление функции кв. уравнения.
* @author astolbov
* @since 10.11.2016
*/

public class Square {
	/**
	* коэфф. при x^2.
	*/
	private float a;
	/**
	* коэфф. при x.
	*/
	private float b;
	/**
	* коэфф.
	*/
	private float c;

   /**
	* Конструктор.
	* @param seta коэфф. при x^2
	* @param setb коэфф. при x
	* @param setc коэфф
	*/
	public Square(float seta, float setb, float setc) {
		this.a = seta;
		this.b = setb;
		this.c = setc;
	}

   /**
	* Вычисляет значение функции для заданного x.
	* @param x переменная уравнения
	* @return y - значение функции
	*/
	public double calculate(int x) {
		return Math.pow(x, 2) * this.a + x * this.b + this.c;
	}

   /**
	* Выводит значения функции в консоль.
	* @param start - начальное значение
	* @param finish - конечное значение
	* @param step - шаг
	*/
	public void show(int start, int finish, int step) {
		for (int i = start; i <= finish; i += step) {
			System.out.printf("x = %1d  y = %2f %n m", i, calculate(i));
		}
	}
}
