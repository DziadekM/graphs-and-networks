package algorithms;

import java.util.HashMap;
import java.util.Map;



//notwendig für Kruskal

public class Teilmenge {
	private Map<Integer, Integer> verbindungen = new HashMap<Integer, Integer>();
	
	//Erstelle neue Teilmengen, für jeden Knoten zunächst eine
	public void makeset(int knotenanzahl) {
		for(int i=1; i<=knotenanzahl; i++) {
			verbindungen.put(i,i);
		}
		System.out.println("Ausgangsmap: " + verbindungen);
	}
	
	//Finde Root-Knoten der Teilmenge
	public int find(int knoten) {
		//Wenn Key und Value den gleichen Wert haben, ist es der Root-Knoten!
		//System.out.println("find Knoten: "+knoten);
		if(verbindungen.get(knoten)==knoten) {
			//System.out.println("If Knoten: "+knoten);
			return knoten;
		}
		//Rekursion 
		//Value-Wert wird an Funktion find übergeben, geschaut, ob es sich um Root-Knoten handelt
		return find(verbindungen.get(knoten));
	}
	
	//Root-Knoten von a mit Root-Knoten von B zu einer neuen Teilmenge verbinden
	public void union(int a, int b) {
		
		//Root-Knoten der beiden Knoten finden
		int x = find(a);
		int y = find(b);
		
		verbindungen.put(x, y);
		System.out.println("Knoten " + a + " wurde der Root-Knoten " + b + " zugeordnet. Neue Hashmap: " + verbindungen);
	}
	
	
	public void printTeilmenge() {
		System.out.println("printTeilmenge: "+verbindungen);
	}
}
