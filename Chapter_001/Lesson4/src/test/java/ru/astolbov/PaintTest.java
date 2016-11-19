package ru.astolbov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Class PaintTest.
* Тест класса Paint
*@author stolbov
*@since 19.11.2016
*/

public class PaintTest {

	/**
	* Проверка рисования пирамиды.
	*/
	@Test
	public void whenPyramideThenPyramide() {
		StringBuilder pyramideWell = new StringBuilder();
		pyramideWell.append("  ^\n");
		pyramideWell.append(" ^ ^\n");
		pyramideWell.append("^   ^\n");

		Paint paint = new Paint();
		String pyramideTest = paint.create(3, 1);

		assertThat(pyramideTest, is(pyramideWell.toString()));
	}
}
