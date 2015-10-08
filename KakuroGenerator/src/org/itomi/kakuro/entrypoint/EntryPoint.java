package org.itomi.kakuro.entrypoint;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import com.sun.glass.ui.Application;

public class EntryPoint {

	
	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		Application app = container.instance().select(Application.class);
		Application.run();
		weld.shutdown();
	}
}
