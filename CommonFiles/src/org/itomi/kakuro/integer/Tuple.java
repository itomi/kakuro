package org.itomi.kakuro.integer;

public class Tuple<P1, P2> {
	private P1 p1;
	private P2 p2;

	public Tuple(P1 p1, P2 p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public P1 getFirst() {
		return p1;
	}
	
	public P2 getSecond() {
		return p2;
	}
	
	@Override
	public String toString() {
		return "[ " + p1.toString() + " : " + p2.toString() + " ]";
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Tuple) {
			Tuple t = (Tuple)obj;
			return p1.equals(t.p1) && p2.equals(t.p2);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (p1.hashCode() + p1.hashCode() + "").hashCode();
	}
}
