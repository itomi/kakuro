package org.itomi.kakuro.gen;

import org.itomi.kakuro.model.fields.Field;



public class Generator {
 private Field field = null;
 
 public Generator() {
	 field = new Field();	
}
 
 public String printGenerator() {
	 return field.toString();
 }
}
