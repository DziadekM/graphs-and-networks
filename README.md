# graphs-and-networks
Hochschule Fulda
Modul: Graphen &amp; Netzwerke


## Algorithmen
Folgende Algorithmen wurden implementiert:
- Topsort (topologische Sortierung)
- Kruskal
- Dijkstra

## Programm starten
Die verschiedenen Algorithmen können über die `Main.class` gestartet werden. Bitte beachten, hierfür müssen die entsprechenden Bereiche auskommentiert werden.

## Dotformat erzeugen
1. Die Graphen können über das Dotformat erzeugt werden. Hierfür einfach in der `Main.class` den Dotformat-Bereich auskommentieren
2. Datei die erzeugt werden soll einlesen (siehe input-Folder)
3. Programm starten
4. Über die Konsole (Terminal o. Shell) in den Output ordner wechseln (`cd ...`) 
5. Erzeugte Dotformat-Datei in ein png oder svg umwandeln. Je nachdem wie groß die Datei ist, muss das svg Format gewählt werden. Über folgenden Befehl kann der Graph generiert werden: `dot -Tpng DocName.dot -o DocName.png`
