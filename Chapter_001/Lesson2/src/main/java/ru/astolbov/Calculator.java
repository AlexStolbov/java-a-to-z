package ru.astolbov;

	/**
	*Class Calculator
	* выполняет 4 арифметических действия
	*@author stolbov
	*@since 07.11.2016
	*/

public class Calculator{
	/**
	*Хранит результат вычисления
	*/
	private double result;

	/**
	*Возвращает результат последнего вычисления
	*/
	public double getResult(){
		return result ;
	}

	/**
	*Сложение
	*@param first - первое слагаемое
	*@param second - второе слагаемое
	*@return сумма
	*/
	public void add(double first, double second){
		this.result = first + second;
	}

	/**
	*Вычитание
	*@param first - уменьшаемое
	*@param second - вычитаемое
	*@return разность
	*/
	public void subtraction(double first, double second){
		this.result = first - second;
	}

	/**
	*Деление
	*@param first - делимое
	*@param second - делитель
	*@return частное
	*/
	public void div(double first, double second){
		if (second != 0)
			this.result = first / second;
		else
			this.result = 0;
	}

	/**
	*Умножение
	*@param first - первый множитель
	*@param second - второй множитель
	*@return произведение
	*/
	public void multiplication(double first, double second){
		this.result = first * second;
	}
}