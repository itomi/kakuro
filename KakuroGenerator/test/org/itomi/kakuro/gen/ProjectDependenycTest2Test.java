package org.itomi.kakuro.gen;
import org.itomi.kakuro.model.fields.Field;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ProjectDependenycTest2Test {

	ProjectDependenycTest2 testedObject = null;
	
	@Before
	public void beforeClass() {
		testedObject = new ProjectDependenycTest2();
	}
	
	@Test
	public void test_testSettersAndGetters() {
		testedObject.setField(new Field());
		Assert.assertNotNull("Cooles", testedObject.getField());
	}
	
}
