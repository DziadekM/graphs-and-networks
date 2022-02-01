package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import graph.Adjazenzliste;

public class Topsort {
	
	
	//Constructor
	public Topsort() {
		
	}
	
	//implementing the topsort algorithm
	public static void topsort(Adjazenzliste adj) {
		//Adjazenzliste in ArrayList speichern
		ArrayList<Integer>[] ali = adj.getAdjazenzliste();
		
		//Warteschlange öffnen, 
		/*Bei einer LinkedList stehen alle Listenelemente in Verbindung zum jeweiligen Vorgänger 
		 * bzw. Nachfolger. Existiert kein Nachfolger, so verweist das letzte Element auf die null-Referenz.
		 */
		Queue<Integer> q = new LinkedList<Integer>();
		
		//Array für Ausgabe des Topsort-Ergebnisses anlegen
		int[] topsort = new int[ali.length];
		
		//Int-Array, in dem für jeden Knoten die Anzahl der Eingänge (indegrees) gespeichert werden
		int[] indegrees = new int[ali.length];
		
		
		//Gehe durch das Array von Listen und jeweils durch die entsprechende Liste
		for(int i=0; i<ali.length; i++) {
			//[0]
			for(int j=0; j<ali[i].size(); j++) {
				//[0]=>[2][3][4][5]
				//Für jeden Knoten u, der an einem Knoten v hängt, zähle die Stelle im Array indegrees um 1 hoch
				indegrees[(ali[i].get(j))-1]++; //-1 damit Stelle 0 in Array
				System.out.println("indegrees am Index "+i+" ist "+(ali[i].get(j)-1));
			}
			
		}
		//System.out.println(Arrays.toString(indegrees));
		
		//Erstes Element ohne indegree in Queue einfügen:
				for (int k=0; k<indegrees.length; k++) {
					if(indegrees[k]==0) {
						//Knoten immer 1 mehr, da kein Knoten 0
						q.add(k+1);
						
					}
					
				}
				
				
				//Jeder Knoten wird genau einmal in das Array Topsort geschrieben (Sortierung).
				System.out.println("Indegrees Main "+Arrays.toString(indegrees));
				for(int l = 0; l<indegrees.length; l++) {
					
					//Wenn Queue leer wird, bevor alle Knoten eingetragen wurden, gibt es einen Zyklus!
					if(q.isEmpty()) {
						System.out.println("ACHTUNG! Graph enthält Zyklus! Keine topologische Sortierung möglich");
						break;
					}
					//Array Topsort befüllen mit 1. Knoten aus der Queue
					topsort[l] = q.poll(); //Knoten löschen
					//System.out.println("Topsort Array füllen " +topsort[l]);
					
					//Durch die Liste des entsprechenden 1. Knotens aus der Queue gehen
					//Mit welchen weiteren Knoten war der erste Knoten verbunden?
					//ali[topsort[l]-1]) => gibt Knotenverbindungen aus
					System.out.println("Knotenverbindung an Index ["+l+"] "+ ali[topsort[l]-1]);
					for(int nodeConnection : ali[topsort[l]-1]) {
						System.out.println("Verbindung : ["+l+"] " +nodeConnection);
						
						
						//alle Kanten, mit denen der gelöschte Knoten verbunden war, aus der Liste löschen
						indegrees[nodeConnection-1]--; 
						
						
						//Wenn ein Knoten den Wert 0 bekommt, keine weitere Verbindung mehr hat, kommt dieser in die Queue
						if(indegrees[nodeConnection-1]==0) { 
							System.out.println("Im If "+nodeConnection);
							q.add(nodeConnection);
							//System.out.println(nodeConnection + " wurde zu Topsort hinzugefügt");
						}
					}
					System.out.println("Indegrees Durchlauf "+Arrays.toString(indegrees));
					
				}
				System.out.println("Indegrees Ende "+Arrays.toString(indegrees));
				System.out.println("Topsort-Ergebnis: " + Arrays.toString(topsort));
		
	}
	
	
	

}//END algo
