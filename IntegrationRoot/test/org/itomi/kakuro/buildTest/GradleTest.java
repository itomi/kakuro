package org.itomi.kakuro.buildTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GradleTest {
	private static Logger LOG = LoggerFactory.getLogger(GradleTest.class);
	
	@Test
	public void test_IntegrationRootBuildScript() {
		LOG.info("Dependency management working!");
	}
}
