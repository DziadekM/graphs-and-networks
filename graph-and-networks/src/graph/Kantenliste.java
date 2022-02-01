package graph;

import java.util.ArrayList;

/*Class to define a Kantenliste*/


public class Kantenliste {
	
	private int knotenanzahl;
	private ArrayList<Kante> kanten;
	
	
	//Konstruktor: Kantenlisten-Objekt erzeugen
	public Kantenliste(int knotenanzahl) {
		this.setKnotenanzahl(knotenanzahl);
		this.setKanten(new ArrayList<Kante>());
	}
	

	public ArrayList<Kante> getKanten() {
		return kanten;
	}
	
	public void addKante(Kante k) {
		getKanten().add(k);
	}
	
	
	//Kantenliste auf der Konsole ausgeben
	/*Example K5:
	 * 	1 2
		1 3
		1 4
		1 5
		2 3*/
	public void printListe() {
		System.out.println("Kantenliste wird gemäß Beispielgraphen aus dem eLearning angezeigt");
		for(int i=0; i<this.getKanten().size(); i++) {
			System.out.println(this.getKanten().get(i).getStartknoten() + " " + this.getKanten().get(i).getEndknoten());
		}
	}

	//Anzahl der Kanten ausgeben
	public int size() {
		return this.getKanten().size();
	}


	public void setKanten(ArrayList<Kante> kanten) {
		this.kanten = kanten;
	
	}

	public int getKnotenanzahl() {
		return knotenanzahl;
	}

	
	public void setKnotenanzahl(int knotenanzahl) {
		this.knotenanzahl = knotenanzahl;
	}
	
	//Kantenliste auf der Konsole inkl. Gewichtung ausgeben
	public void printKantenliste() {
		System.out.println("Kantenliste wird angezeigt: Startknoten Endknoten Gewichtung");
		for (Kante i: this.kanten) {
			i.printKante();
		}
	}

}
