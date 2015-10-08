package org.itomi.kakuro.entrypoint;

import javax.enterprise.inject.Instance;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


public class EntryPoint {

	
	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		Instance<Application> select = container.instance().select(Application.class);
		select.get().run();
		weld.shutdown();
	}
}
