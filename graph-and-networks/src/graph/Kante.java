package graph;

/*Class Kante defines a edge*/

public class Kante {
	/*Eine Kante ist defniert über einen 
	 * - Startknoten
	 * - Endknoten 
	 * - Gewicht */
	private int startknoten;
	private int endknoten;
	private int weight;
	
	//Konstruktur: wenn Kante nur Start- und Endknoten hat
	public Kante(int startknoten, int endknoten) {
		this.setStartknoten(startknoten);
		this.setEndknoten(endknoten);
	}
	
	//Konstruktur: wenn Kante Start- und Endknoten und ein Gewicht hat
	public Kante(int startknoten, int endknoten, int weight) {
		this.setStartknoten(startknoten);
		this.setEndknoten(endknoten);
		this.setWeight(weight);
	}

	
	public int getStartknoten() {
		return startknoten;
	}


	public void setStartknoten(int startknoten) {
		this.startknoten = startknoten;
	}

	
	public int getEndknoten() {
		return endknoten;
	}

	
	public void setEndknoten(int endknoten) {
		this.endknoten = endknoten;
	}

	
	public int getWeight() {
		return weight;
	}
	
	
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	//CONSOLE: Kanten auf der Konsole ausgeben
	/*Beispiel: Kantenliste wird angezeigt: 
	 * 
	 * Startknoten Endknoten Gewichtung
		1 2 0
		1 3 0
		1 4 0*/
	public void printKante() {
		System.out.println("printKante "+this.startknoten + " " + this.endknoten + " " + this.weight);
	}
	
}
