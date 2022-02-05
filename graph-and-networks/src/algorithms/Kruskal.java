package algorithms;
import java.util.*;
import java.util.stream.Collectors;

import graph.Kante;
import graph.Kantenliste;


public class Kruskal {
	
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
		for(Kante kante:kantenListe) {
			kante.printKante();
		}
		
		//Liste für die minimalen Spanning trees anlegen
		List<Kante> mst = new ArrayList();
		
		//neue Teilmenge anlegen
		Teilmenge tlm = new Teilmenge();
		
		//für die Teilmenge ein Set über die Anzahl der Knoten erstellen
		tlm.makeset(knotenanzahl);
		tlm.printTeilmenge();
		
		int index = 0;
		
		//solange das Set noch nicht voll ist => iterieren
		while(mst.size()!= knotenanzahl-1) {
			
			/*nächste Kante mit geringsten Gewicht einlesen 
			 * (Liste ist ja bereits schon nach Gewicht sortiert, d.h. die nächste Kante ist
			 * automatisch die mit dem nächst größeren Gewicht)*/
			
			Kante nextk = kantenListe.get(index++);
			
			
			
			int startknoten = tlm.find(nextk.getStartknoten());
			//System.out.println("Startknoten aus Teilmenge "+startknoten);
			int endknoten = tlm.find(nextk.getEndknoten());
			//System.out.println("Endknoten aus Teilmenge "+endknoten);
			
			if(startknoten!=endknoten) {
				//Kante zum minimalen spanning tree hinzufügen
				mst.add(nextk);
				
				//Start- und Endknoten miteinander vereinigen => 1 4 zu 14
				tlm.union(startknoten, endknoten);
				
			}
			else {
				System.out.println("ACHTUNG Zyklus entstanden! " + nextk.getStartknoten() + " " + nextk.getEndknoten());
			}
		}
		
		/* minimalen Spannbaum auf Konsole ausgeben*/
		for(Kante kante: mst) {
			kante.printKante();
		}
	}

}
