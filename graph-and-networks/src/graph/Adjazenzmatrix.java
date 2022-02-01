package graph;

/*Definition einer Adjazenzmatrix*/

public class Adjazenzmatrix {
	
	//Array für Matrix anlegen & boolean für Gewichtung
	private int[][] adjazenzmatrix;
	private boolean gewichtet;
	
	//Konstruktor
	public Adjazenzmatrix(int knotenanzahl) {
		
		this.adjazenzmatrix = new int[knotenanzahl][knotenanzahl];
		for(int i=0; i<knotenanzahl-1; i++) {
			for(int j = 0; j<knotenanzahl-1; j++) {
				this.adjazenzmatrix[i][j] = 0;
			}
		}
	}
	
	public int[][] getAdjazenzmatrix() {
		return this.adjazenzmatrix;
	}

	public boolean isGewichtet() {
		return gewichtet;
	}

	public void setGewichtet(boolean gewichtet) {
		this.gewichtet = gewichtet;
	}
	

	/*Methode: Kantenliste in Adjazenzmatrix umwandeln*/
	public static Adjazenzmatrix kantenlisteToAdjazenzmatrix(Kantenliste k) {
		Adjazenzmatrix adj = new Adjazenzmatrix(k.getKnotenanzahl());
		for (int i = 0; i < k.size(); i++) {
			
			int startknoten = k.getKanten().get(i).getStartknoten()-1;
			int endknoten = k.getKanten().get(i).getEndknoten()-1;
			//ungerichtete Graphen
			if(k.getKanten().get(i).getWeight()==0) {
				adj.setGewichtet(false);
				adj.getAdjazenzmatrix()[startknoten][endknoten]=1;
			//gewichtete Graphen
			} else {
				adj.setGewichtet(true);
				adj.getAdjazenzmatrix()[startknoten][endknoten]= k.getKanten().get(i).getWeight();
			}
		}
		return adj;
	}
	
}
