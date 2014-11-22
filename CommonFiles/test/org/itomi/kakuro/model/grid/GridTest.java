package org.itomi.kakuro.model.grid;

import org.junit.Assert;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.itomi.kakuro.model.fields.Field;
import org.junit.Before;
import org.junit.Test;

public class GridTest {

	Grid testedObject;

	@Before
	public void before() {
		testedObject = new Grid();
	}

	@Test
	public void test_initalizeGridWithNotNullFields() {
		int x = 100;
		int y = 100;

		Grid grid = testedObject.initialize(x, y);
		Assert.assertNotNull(grid);

		Field[][] matrix = grid.getMatrix();
		Assert.assertNotNull(matrix);
		try {
			for (int i = 0; i < x; i++) {
				for (int j = 0 ; j < y; j++) {
					Assert.assertNotNull(
							"One of fields is null!" + i + " " + j,
							matrix[i][j]);
					if (!(matrix[i][j] instanceof Field)) {
						Assert.fail("Field initialized with different values than BlankField"
								+ matrix[i][j].getClass().toString());
					}
				}
			}
		} catch (Exception e) {
			Assert.fail("Checking of fields caused exception thrown: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
