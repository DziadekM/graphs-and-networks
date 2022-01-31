package graph;

import java.util.ArrayList;


public class Adjazenzliste {
	
	private ArrayList<Integer>[] adjazenzliste;
	private boolean gerichtet;
	
	
	//Konstruktor: Knotenanzahl kommt über Kantenliste
	public Adjazenzliste(int knotenanzahl) {
		
		adjazenzliste = new ArrayList[knotenanzahl];
		for(int i=0; i<knotenanzahl; i++) {
			//fülle Adjazenzlisten Array mit einer ArrayList an jedem Index
			adjazenzliste[i] = new ArrayList<Integer>();
			//adjazenzliste[i].add(i+1);
		}
	}
	
	
	
	public ArrayList<Integer>[] getAdjazenzliste(){
		return this.adjazenzliste;
	}
	
	
	
	public boolean isGerichtet() {
		return gerichtet;
	}
	
	
	
	public void setGerichtet(boolean gerichtet) {
		this.gerichtet = gerichtet;
	}
	
	
	
	/*METHODE: Kantenliste in Adjazenzliste umwandeln*/
	public static Adjazenzliste kantenlisteToAdjazenzliste(Kantenliste k) {
		//Adjazenzlisten Objekt erstellen, Größe = Anzahl der Knoten aus Kantenliste
		Adjazenzliste ali = new Adjazenzliste(k.getKnotenanzahl());
		
		//Wenn die Kanten keine Gewichte haben (Kantenliste = 2 spaltig)
		if(k.getKanten().get(0).getWeight()==0) {
			//...der Graph ist ungerichtet
			ali.setGerichtet(false);
		}
		else {
			// wenn die Kanten Gewichte haben, dann ist der Graph gerichtet
			ali.setGerichtet(true);
		}
		
		
		//TODO: ausblenden bei Vorführung
		System.out.println("Print Adjazenzliste für eingelesenen Graphen: " + k.size());

		for (int i = 0; i < k.size(); i++) {
			
			int startknoten = k.getKanten().get(i).getStartknoten()-1;
			
			int endknoten = k.getKanten().get(i).getEndknoten();
			
			System.out.println("["+i+"] => "+ startknoten + " "+endknoten);
			/* * Adjazenzliste in der folgenden Struktur füllen:
			 * 		[0] => 0 2
					[1] => 0 3
					[2] => 0 4
					[3] => 0 5
					[4] => 1 3
					[5] => 1 4
					[6] => 1 5
					[7] => 2 4
					[8] => 2 5
					[9] => 3 5
			 	* */
			ali.getAdjazenzliste()[startknoten].add(endknoten);
			
		}
		
		return ali;
	}//END METHODE Kantenliste in Adjazenzliste transformieren
	
}