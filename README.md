# SE1_Uebung1

# Wie kann diese Kommunikationsverbindung nun dennoch mit Hilfe einer zusätzlichen Klasse, welche die dazu notwendige Objekt-Erzeugung übernimmt, aufgebaut werden?  

Man erstellt eine weitere Klasse, welche eine “static” Methode besitzt, die ein neues Objekt des Typen Translator zurueckgibt.    

 
# In welchem Package sollte diese zusätzliche Klasse liegen?  

Diese Klasse sollte in demselben Package liegen wie die Translator-Klassen.   

# Welches Entwurfsmuster (engl.: design pattern) könnte für die Problematik der Objekt-Erzeugung verwendet werden? Was ist der software-technische Nutzen bei der Verwendung des Entwurfsmusters?

Für das Problem sollte das Factory Entwurfsmuster verwendet werden, da dieses die Wartung durch ausgelagerte Objekt-Erstellung erleichtert. Außerdem ist dieses Muster effizient darin den Code zu erweitern und es leserlich zu halten.


# Wie muss man den Source Code des Interface ggf. anpassen, um mögliche auftretende Kompilierfehler zu beseitigen?  

Falls man die Klasse in einem anderen Package erstellt, muesste das Interface public gesetzt werden.    

# Was ist der Vorteil einer separaten Test-Klasse?

-Man trennt Logik von den Tests.  \
-Beugt Fehler vor, wenn in der selben Klasse Abhaengigkeiten auftreten koennen.

# Was ist bei einem Blackbox-Test der Sinn von Äquivalenzklassen?

-Man kann eine begrenzte Anzahl von Testfaellen finden bzw. erstellen um jede Aequivalenzklasse abzudecken.  Dadurch ist es auch viel effizienter, da man nicht fuer jeden Eingabewert einen Test schreiben muss.

# Warum ist ein Blackbox-Test mit JUnit auf der Klasse Client nicht unmittelbar durchführbar?  

Die Methode "display" in der Klasse Client besitzt keinen Rückgabewert, weswegen man \
auch nichts unmittelbar vergleichen kann.  
