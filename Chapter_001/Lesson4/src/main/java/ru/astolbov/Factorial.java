package ru.astolbov;

import java.math.*;

/**
* Class Factorial.
* Вычисление факториала.
* @author astolbov
* @since 12.11.2016
*/

public class Factorial {
	public BigInteger calculate(int n) {
		BigInteger res = BigInteger.valueOf(1);
		if (n < 0) {
			System.out.println("n must be positive");
			res = BigInteger.valueOf(0);
		} else {
			for (int i = 1; i <= n; i++) {
				res = res.multiply(BigInteger.valueOf(i));
			}
		}
		return res;
	}
}
