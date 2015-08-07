package org.itomi.kakuro.gen;
import org.itomi.kakuro.dep.ProjectDependenycTest2;
import org.itomi.kakuro.model.fields.ValueField;
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
		testedObject.setField(new ValueField(null,null,9,9));
		Assert.assertNotNull("Cooles", testedObject.getField());
	}
	
}
