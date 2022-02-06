package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//notwendig für Kruskal

public class Teilmenge {
	private Map<Integer, Integer> myMapSet = new HashMap<Integer, Integer>();
	
	//Erstelle neue Teilmengen, für jeden Knoten zunächst eine
	public void makeset(int knotenanzahl) {
		for(int i=1; i<=knotenanzahl; i++) {
			//Ausgangsdaten in mySet setzen, z.B. 1=1, 2=2..
			myMapSet.put(i,i);
		}
		System.out.println("Ursprungs-Set: " + myMapSet);
	}
	
	//Finde Root-Knoten der Teilmenge
	public int find(int knoten) {
		//Wenn Key=Value dann => Root-Knoten
		//System.out.println("Finde Knoten: "+knoten);
		
		//value aus Map holen & wenn dieser dem übergebenen Knoten entspricht, Knoten ausgeben
		if(myMapSet.get(knoten)==knoten) {
			//System.out.println("Root Knoten: "+knoten);
			return knoten;
		}
		
		/*rekursiver Aufruf, value erneut an Funktion übergeben & prüfen, ob es der Root-Node ist*/
		return find(myMapSet.get(knoten));
	}
	
	//Root-Knoten von A mit Root-Knoten von B zu einer neuen Teilmenge verbinden
	public void union(int a, int b) {
		//Root-Knoten der beiden Knoten finden
		int unionA = find(a);
		int unionB = find(b);
	
		//Map aktualisieren. Key = unionA, Value = unionB
		myMapSet.put(unionA, unionB);
		System.out.println("Union: " + unionA + " mit Root Knoten " + unionB + " vereinigt. Aktualisierung der Map: "+ mapToString(myMapSet));
	}
	
	//Map Ausgabe individualisieren
	public static <K, V> String mapToString(Map<K, V> verbindungen) {
	    return verbindungen.entrySet()
	        .stream()
	        .map(entry -> entry.getKey() + "∪" + entry.getValue())
	        .collect(Collectors.joining(", ", "{", "}"));
	}
	
	
	
}
