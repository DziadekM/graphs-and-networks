package algorithms;
import java.util.*;
import java.util.stream.Collectors;

import graph.Kante;
import graph.Kantenliste;


public class Kruskal {
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static void Kruskalalgorithmus(Kantenliste k) {
		//Knotenanzahl von der Kantenliste holen & in variable speichern
		System.out.println("Knotenanzahl: "+ k.getKnotenanzahl());
		int knotenanzahl = k.getKnotenanzahl();
		
		//alle Kanten von der Kantenliste in ein Kanten ArrayList speichern
		//Kantenliste kommt in der Struktur: Startknoten - Gewicht - Endknoten
		ArrayList<Kante> kantenListe = k.getKanten();
		
		
		
		//Kantenliste nach weight sortieren
		Collections.sort(kantenListe, Comparator.comparingInt(kante -> kante.getWeight()));
		
		
		//geordnete Liste nach geringsten Gewicht auf der Konsole ausgeben
		System.out.println("Geordnete Kantenliste: ");
		System.out.println("S E G");
		for(Kante kante:kantenListe) {
			kante.printKante();
		}
		
		//Liste für die minimalen Spanning trees anlegen
		List<Kante> mst = new ArrayList();
		
		//neue Teilmenge anlegen
		Teilmenge teilmenge = new Teilmenge();
		
		//für die Teilmenge ein Set über die Anzahl der Knoten erstellen
		teilmenge.makeset(knotenanzahl);
	
		
		int index = 0;
		
		/*Baum: V-1 = Anzahl der Kanten 
		 * while-Schleife abbrechen, wenn mst ArrayList mit v-1 Kanten gefüllt ist
		 * */
		while(mst.size()!= knotenanzahl-1) {
			
			/*nächste Kante mit geringsten Gewicht einlesen 
			 * (Liste ist ja bereits schon nach Gewicht sortiert, d.h. die nächste Kante ist
			 * automatisch die mit dem nächst größeren Gewicht)*/
			
			Kante nextKante = kantenListe.get(index++);
	
			
			
			/*Start- und Endknoten der Kante suchen*/
			int startknoten = teilmenge.find(nextKante.getStartknoten());
			int endknoten = teilmenge.find(nextKante.getEndknoten());
		
			
			if(startknoten!=endknoten) {
				//Kante zum minimalen spanning tree hinzufügen
				mst.add(nextKante);
				
				//Start- und Endknoten miteinander vereinigen => 1 4 zu 14
				teilmenge.union(startknoten, endknoten);
				
			}
			else {
				System.out.println(ANSI_CYAN+"ACHTUNG Zyklus entstanden! Knoten: " + nextKante.getStartknoten() + " " + nextKante.getEndknoten());
			}
		}
		
		/* minimalen Spannbaum auf Konsole ausgeben*/
		int weightSum = 0;
		System.out.println(ANSI_GREEN+"-----------OUTPUT MINIMAL SPANNING TREE-----------------------------");
		System.out.println("S E G");
		for(Kante kante: mst) {
			kante.printKante();
			weightSum = weightSum + kante.getWeight();
			
		}
		//aufsummierte Kosten ausgeben
		System.out.println(ANSI_GREEN+"errechnete Kosten (mst): " + weightSum);
		
	}

}
