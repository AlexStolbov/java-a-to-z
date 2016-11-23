package ru.astolbov;

/**
* SubStirng.
* @author astolbov
* @since 22.11.2016
*/

public class SubString {

	/**
	* Find substring.
	* @param origin - origin string.
	* @param sub - the string to search for.
	* @return - true if origin contanis sub.
	*/
	public boolean contains(String origin, String sub) {
		char[] arrayOrigin = new char[origin.length()];
		origin.getChars(0, origin.length(), arrayOrigin, 0);

		char[] arraySub = new char[sub.length()];
		sub.getChars(0, sub.length(), arraySub, 0);

		boolean findSub = true;

		for (int i = 0; i <= (arrayOrigin.length - arraySub.length); i++) {
			findSub = true;
			for (int y = 0; y < arraySub.length; y++) {
				findSub = (arrayOrigin[i + y] == arraySub[y]);
				if (!findSub) {
					break;
				}
			}
			if (findSub) {
				break;
			}
		}
		return findSub;
	}
}
