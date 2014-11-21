package org.itomi.kakuro.gen;

import org.itomi.kakuro.model.fields.Field;
import org.jgrapht.generate.WeightedGraphGenerator;
import org.jgrapht.graph.WeightedMultigraph;



public class Generator {
 private Field field = null;
 WeightedGraphGenerator<V, E> grap = null;
 
 public Generator() {
	 field = new Field();	
}
 
 public String printGenerator() {
	 return field.toString();
 }
}
