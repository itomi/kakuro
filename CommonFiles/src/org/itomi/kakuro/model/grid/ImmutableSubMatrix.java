package org.itomi.kakuro.model.grid;

import org.itomi.kakuro.integer.Tuple;
import org.itomi.kakuro.model.fields.Field;
import org.itomi.kakuro.model.fields.UnasignableField;

/**
 * Klasa ulatwiajaca dostep do pol matrycy danych poprzez stworzenie zmiennych wzglednych od podanego punktu
 * 
 * @author Karol Kulesza
 *
 * @param <T>
 * 		type of matrix
 */
public class ImmutableSubMatrix<T extends Field> {

	private T[][] matrix;
	private int xPos;
	private int yPos;
	private int deltax;
	private int deltay;
	
	public ImmutableSubMatrix(T[][] matrix, int xPos, int yPos, int deltax, int deltay) {
		this.matrix = matrix;
		this.xPos = xPos-1;
		this.yPos = yPos-1;
		this.deltax = deltax;
		this.deltay = deltay;
	}
	
	public T get(int x, int y) {
		try{
			return matrix[xPos+x][yPos+y];
		}catch(Exception e) {
			return (T) new UnasignableField(); // poto by nie bylo nigdy wybrane jesli wychodzi poza wielkosc instancji
		}
	}
	
	public Field[] getHorizontalAndVerticalNeighbors() {
		Field[] neighbors = new Field[4];
		neighbors[0] = get(2, 1);
		neighbors[1] = get(1, 2);
		neighbors[2] = get(1, 0);
		neighbors[3] = get(0, 1);
		
		return neighbors;
	}
	
	public Field getLeftSideNeigbor() {
		return get(0,1);
	}
	
	public Field getUpperSideNeighbor() {
		return get(1,0);
	}
}
