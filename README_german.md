<p style="text-align: center;">
<img src="QuerysAutoClicker_Icon+QAC_Logo.png" alt="QuerysAutoClicker-Logo" style="width: 25%;">
</p>

# QuerysAutoClicker

- **[English version](https://github.com/getQueryString/QuerysAutoClicker/blob/master/README.md)**
- [Unser QuerysCommunity Discord-Server](https://discord.gg/AeGFarvQyk)

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

<p style="text-align: justify;">
Ich danke all den Leuten, die mir in der Zeit, wo ich QuerysAutoClicker programmiert habe, geholfen haben.
Ob es ein Feedback oder Vorschlag war, es hat dazu beigetragen, QuerysAutoClicker schöner und besser zu gestalten.
Da dies mein erstes großes Projekt ist und ich kein Profiprogrammierer bin, bekam ich noch öfters negatives Feedback, ließ mich aber gern verbessern.
Diese Hilfe nahm ich immer dankend an. An all die Leute da draußen, die auch mal programmieren woll[t]en:
Lasst euch nicht unterkriegen, wenn ihr euer Programm nicht mit dem ersten Versuch zum Laufen bringt oder wenn euch jemand sagt, dass euer Programmierstil nicht der beste ist.
Fragt nach, wenn ihr Fragen haben. Es gibt keine dummen Fragen, es gibt nur dumme Antworten.
Danke!
</p>

## QuerysAutoClicker

<p style="text-align: justify;">
QuerysAutoClicker ist ein in der Programmiersprache <i>Java</i> und in der Auszeichnungssprache <i>CSS</i> programmiertes
Open-Source-Programm, das das Klicken einer Maus beziehungsweise Tippen einer Tastatur simulieren soll.
</p>

## Eigenschaften

<p style="text-align: justify;">
QuerysAutoClicker ist nicht einfach nur ein AutoClicker, mit dem man zum Beispiel in Minecraft eine sehr hohe Klickzahl
haben kann, es gibt auch eine AutoText-Funktion, mit der der eingegebene Text automatisch nachgeschrieben werden kann.
Dabei kann nicht nur die Klick- oder Schreibgeschwindigkeit verändert werden ...
<br>
<br>
QuerysAutoClicker wurde nicht wie andere AutoClicker aus dem Internet gestaltet - es kann nach Belieben angepasst werden:
</p>

- <p style="text-align: justify;">
  Klick- und Warn-Sounds ein- und ausschaltbar
  </p>
- <p style="text-align: justify;">
  Auswahl zwischen 8 Designs
  </p>
- <p style="text-align: justify;">
  Auswahl zwischen 5 Sprachen:
  </p>

    - Englisch
    - Französisch
    - Deutsch
    - Russisch
    - Spanisch
- <p style="text-align: justify;">
  Bei Unklarheiten können <i>Tipps</i> ein- und ausgeschaltet werden. Sind die Tipps aktiviert, erscheinen kurze Hilfstexte,
  wenn man mit der Maus über die Elemente geht.
  </p>
- <p style="text-align: justify;">
  Automatische Update-Suche beim Programmstart ein- und ausschaltbar
  </p>
- <p style="text-align: justify;">
  Immer in den Vordergrund setzbar:
  </p>

    - **Pinnnadel grün**: Immer oben (Immer über allen anderen Fenstern)
    - **Pinnnadel rot**: Hinter anderen Fenstern, sobald andere Fenster über das QuerysAutoClicker-Fenster gezogen werden

- <p style="text-align: justify;">
  Alle Zustände der aufgelisteten einstellbaren Funktionen werden bei Windows automatisch in der <i>QuerysAutoClicker.ser</i>-Datei in "C:\Users\{USER}\" gespeichert.
  </p>

## Hinweise

- <p style="text-align: justify;">
  Wenn du einen Fehler gefunden hast, Verbesserungsvorschläge oder Feedback für uns hast,
  dann schreibe uns bitte eine Nachricht in den dafür vorgesehenen <i>Feedback</i>-Kanal <a href="https://discord.gg/AeGFarvQyk">auf unserem Discord-Server</a>.
  </p>
- <p style="text-align: justify;">
  Beim ersten Starten [einer neuen Version] von QuerysAutoClicker wird bei Windows sehr wahrscheinlich eine Warnung angezeigt werden.
  Um das Programm starten zu können, muss auf <b>Weitere Informationen</b> und dann auf <b>Trotzdem ausführen</b> geklickt werden. Der Grund für
  diese Warnung ist <a href="https://github.com/kwhat/jnativehook">JNativeHook</a>. JNativeHook wird im Programm nur dafür verwendet,
  dass der Start/Stop-Hotkey auch dann erkannt werden kann, ohne dass das Programm im Vordergrund beziehungsweise ausgewählt sein muss.
  </p>
- <p style="text-align: justify;">
  Es ist nicht empfohlen, im QuerysAutoClicker-Programm die Klick- und Schreibgeschwindigkeit sehr hoch einzustellen,
  da der Computer oder das Programm diese Leistung nicht aufbringen kann. Beim AutoText kann es vorkommen, dass durch die ständigen Tastenkombinationen
  andere Dinge passieren oder geöffnet werden. Im Programm ist die zu hoch eingestellte Geschwindigkeit an der roten Schrift zu erkennen.
  Bei <i>Geschwindigkeit</i> wird die Zahl rot, wenn der Wert 200 oder höher ist. Bei <i>Intervall</i> wird die Zahl von <i>Millisekunden</i> rot,
  wenn der Gesamtwert 5 Millisekunden oder niedriger beträgt.
  </p>
- <p style="text-align: justify;">
  Die gespeicherten Zustände werden beim Programmstart zurückgesetzt, wenn die <i>QuerysAutoClicker.ser</i>-Datei in "C:\Users\\{USER}\\"
  beschädigt oder gelöscht wurde. Das Speichern der Zustände wird zurzeit nur bei Windows unterstützt.
  </p>

## Installation

### Linux (Nicht fehlerfrei)

1. <p style="text-align: justify;">
   <b>Terminal öffnen</b>: <i>Strg</i> + <i>Alt</i> + <i>T</i>
   <br>
   Die neueste Version von QuerysAutoClicker herunterladen und JDK 17 (Java Development Kit) installieren:
   </p>

   ```
   git clone https://github.com/getQueryString/QuerysAutoClicker.git
   sudo apt update
   sudo apt install openjdk-17-jdk
   ```
2. <p style="text-align: justify;">
   <a href="https://gluonhq.com/products/javafx/">JavaFX 17 oder 19</a> für Linux herunterladen und installieren. Typ: <i>SDK</i>
   </p>
3. <p style="text-align: justify;">
   QuerysAutoClicker im Terminal starten:
   </p>

   ```
   java --module-path /{PFAD}/javafx-sdk-{VERSION}/lib --add-modules javafx.controls,javafx.media,javafx.fxml -jar
   /{PFAD}/QuerysAutoClicker/lib/QuerysAutoClicker-1.0.0.jar
   ```
   <p style="text-align: justify;">
   oder den bearbeiteten Befehl in eine <i>Shell Script (.sh)</i>-Datei kopieren und dieser <i>Shell Script</i>-Datei die Berechtigung geben,
   dass sie als Programm ausgeführt werden darf:
   </p>

   ```
   chmod +x {NAME}.sh
   ```
   und die _.sh_-Datei ausführen:
   ```
   ./{NAME}.sh
   ```

### macOS (Nicht fehlerfrei)

1. <p style="text-align: justify;">
   <b>Terminal öffnen</b>: <i>Command (⌘)</i> + <i>Leertaste</i> > nach <i>Terminal</i> suchen.
   <br>
   Die neueste Version von QuerysAutoClicker herunterladen und JDK 17 (Java Development Kit) installieren:
   </p>

   ```
   git clone https://github.com/getQueryString/QuerysAutoClicker.git
   jdk-17_macos-x64_bin.dmg   ODER   jdk-17_macos-x64_bin.tar.gz
   ```

2. <p style="text-align: justify;">
   <a href="https://gluonhq.com/products/javafx/">JavaFX 17 oder 19</a> für macOS herunterladen und installieren. Typ: <i>SDK</i>
   </p>
3. <p style="text-align: justify;">
   Berechtigung <i>Apps dürfen diesen Computer steuern</i> hinzufügen: <i>Systemeinstellungen</i> > <i>Sicherheit</i> > <i>
   Bedienungshilfen</i> > <i>Terminal</i>
   </p>
4. ```
   java --module-path /{PFAD}/javafx-sdk-{VERSION}/lib --add-modules javafx.controls,javafx.media,javafx.fxml -jar
   /{PFAD}/QuerysAutoClicker/lib/QuerysAutoClicker-1.0.0.jar
   ```
   <p style="text-align: justify;">
   oder den bearbeiteten Befehl in eine <i>Shell Script (.sh)</i>-Datei kopieren und dieser <i>Shell Script</i>-Datei die Berechtigung geben,
   dass sie als Programm ausgeführt werden darf:
   </p>

   ```
   chmod +x {NAME}.sh
   ```

   Diese _.sh_-Datei ausführen:
   <br>
   Bourne shell:
   ```
   sh {NAME}.sh
   ```
   Bash:
   ```
   bash {NAME}.sh
   ```

### Windows

1. <p style="text-align: justify;">
   <a href="https://www.oracle.com/java/technologies/downloads/#java17">JDK 17 oder 19</a> (Java Development Kit) für Windows herunterladen und installieren (Zum Beispiel: <i>x64 Installer</i> oder <i>x64 MSI
   Installer</i>)
   </p>
2. <p style="text-align: justify;">
   <a href="https://api.github.com/repos/getQueryString/QuerysAutoClicker/releases/">Die neueste Version von QuerysAutoClicker herunterladen</a>, zu "\QuerysAutoClicker\lib\" navigieren und die Datei <i>QuerysAutoClicker-1.0.0.jar</i> ausführen.
   </p>

## Kompatibilität

<p style="text-align: justify;">
<b>JDK</b>: <a href="https://www.oracle.com/java/technologies/javase/products-doc-jdk17certconfig.html">Oracle JDK 17</a> / <a href="https://www.oracle.com/java/technologies/javase/products-doc-jdk19certconfig.html">Oracle JDK 19</a>
<br>
<b>JavaFX</b>: In der <i>JavaFX 1.2 SDK Requirements-</i>Tabelle <a href="https://www.oracle.com/java/technologies/javafx/system-requirements.html#javafxsdk">auf der Webseite von Oracle</a>
sind nur die Zeilen <i>Processors</i>, <i>Operating System</i>, Memory und <i>Disk Space</i> relevant.
</p>

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

<p style="text-align: justify;">
Bei Schäden oder Ähnliches am Computer, die durch den AutoClicker oder AutoText verursacht werden, übernehme ich <b>keine Haftung</b>,
da das Verwenden von QuerysAutoClicker auf eigenes Risiko zu verwenden ist. Passieren kann ...
</p>

- <p style="text-align: justify;">
  ... durch den AutoClicker, dass alles, was vom Mauszeiger berührt wird, angeklickt wird.
  </p>
- <p style="text-align: justify;">
  ... durch den AutoText laut aktuellem Kenntnisstand nichts.</p>

## Copyright

<p style="text-align: justify;">
Copyright von getQueryString/Fin © Alle Rechte vorbehalten. Download nur auf vorgegebenen Webseiten;
keine Inhalte vom Programm dürfen für andere Zwecke verwendet, verändert oder als eigenes Werk oder Ähnliches ausgegeben werden.
</p>