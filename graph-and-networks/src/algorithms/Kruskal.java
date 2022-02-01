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
		ArrayList<Kante> klist = k.getKanten();
		
		
		
		//Kantenliste nach weight sortieren
		Collections.sort(klist, Comparator.comparingInt(e -> e.getWeight()));
		
		//geordnete Liste nach geringsten Gewicht auf der Konsole ausgeben
		for(Kante kan:klist) {
			kan.printKante();
		}
		
		//Liste für die minimalen Spanning trees anlegen
		List<Kante> mst = new ArrayList();
		
		//neue Teilmenge anlegen
		Teilmenge tlm = new Teilmenge();
		
		//für die Teilmenge ein Set über die Anzahl der Knoten erstellen
		tlm.makeset(knotenanzahl);
		
		int index = 0;
		
		//solange das Set noch nicht voll ist => iterieren
		while(mst.size()!= knotenanzahl-1) {
			
			/*nächste Kante mit geringsten Gewicht einlesen 
			 * (Liste ist ja bereits schon nach Gewicht sortiert, d.h. die nächste Kante ist
			 * automatisch die mit dem nächst größeren Gewicht)*/
			
			Kante nextk = klist.get(index++);
			
			
			
			int startknoten = tlm.find(nextk.getStartknoten());
			//System.out.println("Startknoten aus Teilmenge "+startknoten);
			int endknoten = tlm.find(nextk.getEndknoten());
			//System.out.println("Endknoten aus Teilmenge "+endknoten);
			
			if(startknoten!=endknoten) {
				//Kante zum minimalen spanning tree hinzufügen
				mst.add(nextk);
				
				//Main- und Endknoten miteinander vereinigen => 1 4 zu 14
				tlm.union(startknoten, endknoten);
				
			}
			else {
				System.out.println("Zyklus! " + nextk.getStartknoten() + " " + nextk.getEndknoten());
			}
		}
		for(Kante kante: mst) {
			kante.printKante();
		}
	}

}
