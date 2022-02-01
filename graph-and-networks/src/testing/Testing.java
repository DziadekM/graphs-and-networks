package testing;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import graph.Kante;
import graph.Kantenliste;

public class Testing{
	
	public static void main(String[] args) {
		Kantenliste k = readFile("k5");
		k.printListe();
		k.printKantenliste();
		

	}
	
	
	
	
	public static Kantenliste readFile(String file) {
		Kantenliste k = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("input/"+file+".txt"));
			int knotenanzahl = Integer.parseInt(reader.readLine());
			k = new Kantenliste(knotenanzahl);
			
			String line = reader.readLine();
			
			while(line != null) {
				String[] splitline = line.split(" ");
				//Ungerichteter Graph
				if(splitline.length==2) {
					k.addKante(new Kante(Integer.parseInt(splitline[0]), Integer.parseInt(splitline[1])));
				}
				//gewichteter Graph
				else {
					k.addKante(new Kante(Integer.parseInt(splitline[0]), Integer.parseInt(splitline[2]), Integer.parseInt(splitline[1])));
				}
				line = reader.readLine();
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}
		return k;
	}//END Kantenliste
	
	
}//END Testing