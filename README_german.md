<p style="text-align: center;">
<img src="QuerysAutoClicker_GitHub_Logo.png" alt="QuerysAutoClicker-Logo" style="width: 25%;">

# QuerysAutoClicker (QAC)

- **[English version](https://github.com/getQueryString/QuerysAutoClicker/blob/master/README.md)**
- [Unser QueryCommunity Discord-Server](https://discord.gg/AeGFarvQyk)

## Inhaltsverzeichnis

1. [Danke](#Danke)
2. [QuerysAutoClicker](#QuerysAutoClicker)
3. [Eigenschaften](#Eigenschaften)
4. [Hinweise](#Hinweise)
5. [Installation](#Installation)
6. [Kompatibilität](#Kompatibilität)
7. [Mitwirkende](#Mitwirkende)
8. [Haftungsausschluss](#Haftungsausschluss)
9. [Copyright](#Copyright)

## Danke

Ich danke all den Leuten, die mir in der Zeit, wo ich QuerysAutoClicker programmiert habe, geholfen haben.
Ob es ein Feedback oder Vorschlag war, es hat dazu beigetragen, QuerysAutoClicker schöner und besser zu gestalten.
Da dies mein erstes großes Projekt ist und ich kein Profiprogrammierer bin, bekam ich noch öfters negatives Feedback, ließ mich aber gern
verbessern.
Diese Hilfe nahm ich immer dankend an. An all die Leute da draußen, die auch mal programmieren woll[t]en:
Lasst euch nicht unterkriegen, wenn ihr euer Programm nicht mit dem ersten Versuch zum Laufen bringt oder wenn euch jemand sagt, dass euer
Programmierstil nicht der beste ist.
Fragt nach, wenn ihr Fragen haben. Es gibt keine dummen Fragen, es gibt nur dumme Antworten.
Danke!

## QuerysAutoClicker

QuerysAutoClicker ist ein in der Programmiersprache _Java_ und in der Auszeichnungssprache _CSS_ programmiertes
Open-Source-Programm, das das Klicken einer Maus beziehungsweise Tippen einer Tastatur simulieren soll.

## Eigenschaften

QuerysAutoClicker ist nicht einfach nur ein AutoClicker, mit dem man zum Beispiel in Minecraft eine sehr hohe Klickzahl
haben kann, es gibt auch eine AutoText-Funktion, mit der der eingegebene Text automatisch nachgeschrieben werden kann.
Dabei kann nicht nur die Klick- oder Schreibgeschwindigkeit verändert werden ...
<br>
<br>
QuerysAutoClicker wurde nicht wie andere AutoClicker aus dem Internet gestaltet - es kann nach Belieben angepasst werden:

- Klick- und Warn-Sounds ein- und ausschaltbar
- Auswahl zwischen 8 Designs
- Auswahl zwischen 5 Sprachen:
    - Englisch
    - Französisch
    - Deutsch
    - Russisch
    - Spanisch
- Bei Unklarheiten können _Tipps_ ein- und ausgeschaltet werden. Sind die Tipps aktiviert, erscheinen kurze Hilfstexte, wenn man mit
  der Maus über die Elemente geht.
- Automatische Update-Suche beim Programmstart ein- und ausschaltbar
- Immer in den Vordergrund setzbar:
    - **Pinnnadel grün**: Immer oben (Immer über allen anderen Fenstern)
    - **Pinnnadel rot**: Hinter anderen Fenstern, sobald andere Fenster über das QuerysAutoClicker-Fenster gezogen werden.

- Alle Zustände der aufgelisteten einstellbaren Funktionen werden automatisch in der _QuerysAutoClicker.ser_-Datei gespeichert.

## Hinweise

- Wenn du einen Fehler gefunden hast, Verbesserungsvorschläge oder Feedback für uns hast, dann schreibe uns bitte eine Nachricht in den
  dafür vorgesehenen _Feedback_-Kanal <a href="https://discord.gg/AeGFarvQyk">auf unserem Discord-Server</a>.
    - Uns **bekannte Fehler bei Linux**:
        - Start/Stop-Hotkey muss vorm ersten Start einmal neu gesetzt werden
        - Klickposition funktioniert nicht
        - AutoText funktioniert nur mit _Text einfügen_ und _Zeile für
          Zeile_
    - Uns **bekannte Fehler bei macOS**:
        - AutoText funktioniert nur mit _Text einfügen_ und _Zeile für
          Zeile_
- QuerysAutoClicker benötigt nur für die automatische Update-Suche beim Programmstart eine Internetverbindung.
- Beim ersten Starten [einer neuen Version] von QuerysAutoClicker wird bei Windows möglicherweise eine Warnung angezeigt werden. Um das
  Programm starten zu können, muss auf **Weitere Informationen** und dann auf **Trotzdem ausführen** geklickt werden. Der Grund für
  diese Warnung ist <a href="https://github.com/kwhat/jnativehook">JNativeHook</a>. JNativeHook wird im Programm nur dafür verwendet, dass
  der Start/Stop-Hotkey auch dann erkannt werden kann, ohne dass das Programm im Vordergrund beziehungsweise ausgewählt sein muss.
- Es ist nicht empfohlen, in QuerysAutoClicker die Klick- und Schreibgeschwindigkeit sehr hoch einzustellen, da der Computer oder
  das Programm diese Leistung nicht aufbringen kann. Im Programm ist die zu hoch eingestellte Geschwindigkeit an der roten Schrift zu
  erkennen. Bei _Geschwindigkeit_ wird die Zahl rot, wenn der Wert 200 oder höher ist.
  Bei _Intervall_ wird die Zahl von _Millisekunden_ rot, wenn der Gesamtwert 5 Millisekunden oder niedriger beträgt.
    - Durch den AutoClicker kann es passieren, dass alles, was vom Mauszeiger versehentlich
      berührt wird, angeklickt wird.
    - Durch den AutoText kann es vorkommen, dass durch eine zu hoch eingestellte
      Schreibgeschwindigkeit die ständigen Tastenkombinationen unerwartete Dinge tun oder andere Sachen geöffnet werden.
- Die gespeicherten Zustände werden beim Programmstart zurückgesetzt, wenn die _QuerysAutoClicker.ser_-Datei
  beschädigt oder gelöscht wurde.
- QuerysAutoClicker greift in dem Dateipfad auf die _QuerysAutoClicker.ser_-Datei zu, wo es auch gestartet wurde. Wird
  QuerysAutoClicker hinterher in einem anderen Pfad gestartet, wird eine neue _QuerysAutoClicker.ser_-Datei erstellt.

## Installation

### Linux

1. (Terminal öffnen: _Strg_ + _Alt_ + _T_)
   <br>
   Die Datei _QuerysAutoClicker-1.0.1.tar_ / _.zip_ der
   neuesten Version von <a href="https://github.com/getQueryString/QuerysAutoClicker/releases">QuerysAutoClicker herunterladen</a> und
   entpacken.
2. <a href="https://www.oracle.com/java/technologies/downloads/#java17">JDK 17 (Java Development Kit) für Linux herunterladen</a> und
   installieren oder im Terminal installieren:
   ``` 
   sudo apt update
   sudo apt install openjdk-17-jdk  
   ```
3. <a href="https://gluonhq.com/products/javafx/">JavaFX 19 für Linux herunterladen</a> und installieren. Typ: _SDK_
4. QuerysAutoClicker im Terminal starten:
   ```  
   java --module-path /{PFAD}/javafx-sdk-19/lib --add-modules javafx.controls,javafx.media,javafx.fxml -jar /{PFAD}/QuerysAutoClicker/lib/QuerysAutoClicker-1.0.1.jar 
   ```
   oder den bearbeiteten Befehl in eine _Shell Script (.sh)_-Datei kopieren und dieser _Shell Script_-Datei die Berechtigung
   geben, dass sie als Programm ausgeführt werden darf:
   ```  
   chmod +x {NAME}.sh  
   ```
   und die _.sh_-Datei ausführen:
   ``` 
   ./{NAME}.sh 
   ```

### macOS

1. (Terminal öffnen: _Command (⌘)_ + _Leertaste_ > nach _Terminal_ suchen)
   <br>
   Die Datei _QuerysAutoClicker-1.0.1.tar_ / _.zip_ der
   neuesten Version von <a href="https://github.com/getQueryString/QuerysAutoClicker/releases">QuerysAutoClicker herunterladen</a> und
   entpacken.
2. <a href="https://www.oracle.com/java/technologies/downloads/#java17">JDK 17 (Java Development Kit) für macOS herunterladen</a> und
   installieren oder im Terminal installieren:
   ``` 
   jdk-17_macos-x64_bin.dmg   ODER   jdk-17_macos-x64_bin.tar.gz
   ```
3. <a href="https://gluonhq.com/products/javafx/">JavaFX 19 für macOS herunterladen</a> und installieren. Typ: _SDK_
4. Berechtigung _Apps dürfen diesen Computer steuern_ hinzufügen: _Systemeinstellungen_ > _Sicherheit_ > _
   Bedienungshilfen_ > _Terminal_
5. QuerysAutoClicker im Terminal starten:
   ```
   java --module-path /{PFAD}/javafx-sdk-19/lib --add-modules javafx.controls,javafx.media,javafx.fxml -jar /{PFAD}/QuerysAutoClicker/lib/QuerysAutoClicker-1.0.1.jar
   ```
   oder den bearbeiteten Befehl in eine _Shell Script (.sh)_-Datei kopieren und dieser _Shell Script_-Datei die Berechtigung
   geben, dass sie als Programm ausgeführt werden darf:
   ```
   chmod +x {NAME}.sh 
   ```
   Diese _.sh_-Datei ausführen:<br>
   Bourne shell:
   ```
   sh {NAME}.sh
   ```
   Bash:
   ```
   bash {NAME}.sh
   ```

### Windows

1. <a href="https://www.oracle.com/java/technologies/downloads/#java17">JDK 17 (Java Development Kit) für Windows herunterladen</a>
   und installieren. (Zum Beispiel: _x64 Installer_ oder _x64 MSI Installer_)
2. Die Datei _QuerysAutoClicker-1.0.1.tar_ / _.zip_ der neuesten
   Version von <a href="https://github.com/getQueryString/QuerysAutoClicker/releases">QuerysAutoClicker herunterladen</a> und
   entpacken.
3. Die Datei _QuerysAutoClicker-1.0.1.jar_ in "\QuerysAutoClicker\lib\" ausführen.

## Kompatibilität

**JDK**: <a href="https://www.oracle.com/java/technologies/javase/products-doc-jdk17certconfig.html">Oracle JDK 17</a>
/ <a href="https://www.oracle.com/java/technologies/javase/products-doc-jdk19certconfig.html">Oracle JDK 19</a>
<br>
**JavaFX**: In der _JavaFX 1.2 SDK Requirements-_
Tabelle <a href="https://www.oracle.com/java/technologies/javafx/system-requirements.html#javafxsdk">auf der Webseite von Oracle</a>
sind nur die Zeilen _Processors_, _Operating System_, Memory und _Disk Space_ relevant.

## Mitwirkende

**Gründer und Ideen:**
<br>
getQueryString, Jovan
<br>
<br>
**Design:**
<br>
Technocracy, getQueryString
<br>
<br>
**Programmiert von:**
<br>
getQueryString

## Haftungsausschluss

Bei Schäden oder Ähnliches am Computer, die durch den AutoClicker oder AutoText verursacht werden, übernehme ich **keine Haftung**,
da QuerysAutoClicker auf eigenes Risiko zu verwenden ist.

## Copyright

Copyright von getQueryString/Fin © Alle Rechte vorbehalten. Download nur auf vorgegebenen Webseiten;
keine Inhalte vom Programm dürfen für andere Zwecke verwendet, verändert oder als eigenes Werk oder Ähnliches ausgegeben werden.