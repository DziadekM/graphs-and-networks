package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;


import graph.Kantenliste;


public class Dotformat {

	//gegebene Kantenliste in das Dotformat umwandeln
	public static void kantenlisteToDotformat(Kantenliste k, String name) {
		newFile(name);
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter("output/" + name + ".dot"));
			if(k.getKanten().get(0).getWeight()==0) {
				myWriter.write("graph{");
				myWriter.newLine();
				for (int i = 0; i < k.size(); i++) {
					myWriter.write(Integer.toString(k.getKanten().get(i).getStartknoten()));
					myWriter.write(" -- ");
					myWriter.write(Integer.toString(k.getKanten().get(i).getEndknoten()));
					myWriter.newLine();
				}

			}
			else {
				myWriter.write("digraph{");
				myWriter.newLine();
				for (int i = 0; i < k.size(); i++) {
					myWriter.write(Integer.toString(k.getKanten().get(i).getStartknoten()));
					myWriter.write(" -> ");
					myWriter.write(Integer.toString(k.getKanten().get(i).getEndknoten()));
					myWriter.write(" [label=");
					myWriter.write(Integer.toString(k.getKanten().get(i).getWeight()));
					myWriter.write("]");
					myWriter.newLine();
				}
			}
			myWriter.write("}");
			myWriter.close();
			System.out.println("Successfully generated the dot file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	
	//neue Datei erzeugen & mit Namen der Datei im dot-Format speichern
	public static void newFile(String name) {
		try {
			File myFile = new File("output/" + name + ".dot");
			if (myFile.createNewFile()) {
				System.out.println("File created: " + myFile.getName());
			} else {
				System.out.println("File already exists in your folder.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred. Please check your program");
			e.printStackTrace();
		}
	}

}
