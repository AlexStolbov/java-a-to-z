package ru.astolbov;

import java.math.BigInteger;

/**
* Class Factorial.
* Вычисление факториала.
* @author astolbov
* @since 12.11.2016
*/

public class Factorial {

	/**
	* Calculate factorial.
	* @param n - n factorial
	* @return n - factorial
	*/

	public BigInteger calculate(int n) {
		BigInteger res;
		if (n < 0) {
			System.out.println("n must be positive");
			res = BigInteger.valueOf(0);
		} else {
			res = BigInteger.valueOf(1);
			for (int i = 1; i <= n; i++) {
				res = res.multiply(BigInteger.valueOf(i));
			}
		}
		return res;
	}
}
