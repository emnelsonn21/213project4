package application;

public class Hawaiian extends Pizza {

	
	@Override 
	public String toString() {
		String str = super.toString();
		return str + " : HAWAIIAN";
	}
}
