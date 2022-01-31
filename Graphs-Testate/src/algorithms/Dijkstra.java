package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import graph.Adjazenzliste;
import graph.Adjazenzmatrix;
import graph.Knoten;

public class Dijkstra {
	
	int[][] adjm;
	int numberOfNodes;
	Set<Integer> menge;
	List<Knoten> allNodes;
	PriorityQueue<Knoten> pq;
	
	public void dijkstraalgorithmus(Adjazenzmatrix a, int start) {
		
		//Erhalte Array, welches die Adjazenzmatrix abbildet
		adjm = a.getAdjazenzmatrix();
		//Anzahl der Knoten: über Anzahl der Integer in der Matrix
		numberOfNodes = adjm.length;
		
		//Arraylist, in der alle Knoten gespeichert sind, Implementierung über Knoten
		allNodes = new ArrayList<Knoten>();
		for(int i = 0; i<numberOfNodes; i++) {
			//Knoten hinzufügen
			allNodes.add(new Knoten());
			//Knotenwert setzen
			allNodes.get(i).setNode(i+1);
		}
		// Main bei Startvertex
		Knoten startvertex = allNodes.get(start-1);
		
		//Implementierung eines Hash-Sets, um die Menge der Knoten, die abgearbeitet wurden, darzustellen
		menge = new LinkedHashSet<Integer>();
		//System.out.println(Arrays.deepToString(adjm));
		
		//Priority-Queue, die immer den Knoten mit der kleinsten Distanz vorne stehen hat
		 pq = new PriorityQueue<Knoten>(new Comparator<Knoten>() {
			@Override
			public int compare(Knoten v1, Knoten v2) {
				return v1.getDist()-v2.getDist();
			}
		});
		
		//Startvertex in Priority Queue mit Distanz = 0
		startvertex.setDist(0);
		pq.add(startvertex);
		
		//Solange die Menge nicht alle Knoten enthält...
		while(menge.size()<numberOfNodes) {
			//Knoten aus Queue entfernen
			Knoten ver = pq.remove();
			//Knoten in Menge hinzufügen
			menge.add(ver.getNode());
			//Nachbarknoten ausfindig machen über Funktion
			nachbarknoten(ver);
		}
		System.out.println(menge);
		for(Knoten vi : allNodes) {
			System.out.println("Knoten: " + vi.getNode() + ", Kosten: " + vi.getDist());
		}
		
	}
	
	public void nachbarknoten(Knoten ver) {
		int distAlt=0;
		int distNeu=0;
		
		//Adjazenzmatrix -> In Zeile von vorherigem Knoten gucken, ob die Spalte einen Wert hat (also != 0)
		for(int i=0; i<numberOfNodes; i++) {
			if((adjm[ver.getNode()-1][i])!=0){
				//entsprechenden Knoten aus Arraylist nehmen
				Knoten v = allNodes.get(i);
				
				//Enthält die Menge den Knoten noch nicht?
				if(!menge.contains(v.getNode())) {
					//Distanz bis zum Vorgängerknoten
					distAlt = v.getDist();
					//Distanz vom Nachbarknoten + Distanz vom Vorgängerknoten
					distNeu = ver.getDist()+ adjm[ver.getNode()-1][i];
					
					//Wenn neue Distanz kleiner ist
					if(distNeu<distAlt) {
						v.setDist(distNeu);
					}
					//Wenn Queue den Knoten noch nicht enthält -> einfügen
					if(!pq.contains(v)) {
						pq.add(v);
					} else {
						/*System.out.println(v.getNode()+" Schon drin");
						for(Knoten vi : pq) {
							System.out.println("Knoten: " + vi.getNode()+ " mit Dist " + vi.getDist());
						}*/
					}
				}
			}
		}
	}

}
