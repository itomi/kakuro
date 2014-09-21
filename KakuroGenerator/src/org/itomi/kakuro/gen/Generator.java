package org.itomi.kakuro.gen;

import org.itomi.kakuro.model.Field;

public class Generator {
 Field field;
 
 public Generator() {
	 field = new Field();	
}
 
 public String printGenerator() {
	 return this.toString();
 }
}
