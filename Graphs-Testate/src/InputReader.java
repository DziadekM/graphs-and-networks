import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import graph.Kante;
import graph.Kantenliste;


public class InputReader{
	
	/*METHOD: read the given kantenliste for the various graphs*/
	public static Kantenliste readFile(String file) {
		Kantenliste k = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("input/"+file+".txt"));
			//erste Zeile enthält Knotenanzahl, daher erste Zeile einlesen & als int parsen
			int knotenanzahl = Integer.parseInt(reader.readLine());
			
			k = new Kantenliste(knotenanzahl);
			
			//erste "offizielle" Zeile einlesen
			String line = reader.readLine();
		
			
			while(line != null) {
				String[] splitline = line.split(" ");
				//Ungerichteter Graph
				if(splitline.length==2) {
					//start- und endknoten über die die kante definiert ist hinzufügen => 1 2
					
					k.addKante(new Kante(Integer.parseInt(splitline[0]), Integer.parseInt(splitline[1])));
				}
				//gewichteter Graph
				else {
					k.addKante(new Kante(Integer.parseInt(splitline[0]), Integer.parseInt(splitline[2]), Integer.parseInt(splitline[1])));
				}
				//nächste Zeile einlesen
				line = reader.readLine();
		
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}
		return k;
	}//END METHOD readFile Kantenliste
	
	
}//END InputReader class


