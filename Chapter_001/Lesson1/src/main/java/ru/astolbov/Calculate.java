package ru.astolbov;

/**
	*Class Calculate решение задачи части 001 урок1
	*@author stolbov
	*@since 05.11.2016
*/

public class Calculate {
	/**
	*Конструктор, вывод строки в консоль
	*/
	
	public static void main(String[] arg){
		System.out.println("Hello world!");
	}
	
	/**
	*Метод для тестирования
	*@param value строка для вывода в консоль
	*/
	
	public String echo(String value){
		return String.format("%s %s %s", value, value, value);
	}
}