<p style="text-align: center;">
<img src="QuerysAutoClicker_Icon+QAC_Logo.png" alt="QuerysAutoClicker logo" style="width: 25%;">
</p>

# QuerysAutoClicker

- **[German version](https://github.com/getQueryString/QuerysAutoClicker/blob/master/README_german.md)**
- [Our QueryCommunity Discord server](https://discord.gg/AeGFarvQyk)

## Table of Contents

1. [Thanks](#Thanks)
2. [QuerysAutoClicker](#QuerysAutoClicker)
3. [Properties](#Properties)
4. [Notes](#Notes)
5. [Installation](#Installation)
6. [Compatibility](#Compatibility)
7. [Contributors](#Contributors)
8. [Disclaimer](#Disclaimer)
9. [Copyright](#Copyright)

## Thanks

<p style="text-align: justify;">
Thanks to all the people who helped me while I was programming QuerysAutoClicker.
Whether it was a feedback or a suggestion, it helped make QuerysAutoClicker nicer and better.
Since this is my first big project and I'm not a professional programmer, I often got negative feedback, but I was happy to improve.
I always gratefully accepted this help. To all the people out there who also want to program:
Don't be discouraged if you can't get your program to work on the first try, or if someone tells you that your programming style isn't the best.
Ask if you have any questions. There are no stupid questions, only stupid answers.
Thanks!
</p>

## QuerysAutoClicker

<p style="text-align: justify;">
QuerysAutoClicker is programmed in the programming language <i>Java</i> and in the markup language <i>CSS</i>
Open source program intended to simulate clicking a mouse or typing on a keyboard.
</p>

## Properties

<p style="text-align: justify;">
QuerysAutoClicker is not just an AutoClicker with which you can get a very high number of clicks in Minecraft, for example
can have, there is also an AutoText function, with which the entered text can be automatically rewritten.
Not only the click or write speed can be changed ...
<br>
<br>
QuerysAutoClicker was not designed like other AutoClickers from the web - it can be customized at will:
</p>

- <p style="text-align: justify;">
  Click and warning sounds can be switched on and off
  </p>
- <p style="text-align: justify;">
  Choice of 8 designs
  </p>
- <p style="text-align: justify;">
  Choice of 5 languages:
  </p>

    - English
    - French
    - German
    - Russian
    - Spanish
- <p style="text-align: justify;">
  If anything is unclear, <i>Tips</i> can be switched on and off. If the tips are activated, short help texts appear,
  when you move the mouse over the elements.
  </p>
- <p style="text-align: justify;">
  Automatic update search when starting the program can be switched on and off
  </p>
- <p style="text-align: justify;">
  Always put in the foreground:
  </p>

    - **Pin is green**: Always on top (Always on top of all other windows)
    - **Pin is red**: Behind other windows when other windows are dragged over the QuerysAutoClicker window

- <p style="text-align: justify;">
  All states of the listed adjustable functions are automatically stored in the <i>QuerysAutoClicker.ser</i> file in "C:\Users\{USER}\" on Windows.
  </p>

## Notes

- <p style="text-align: justify;">
  If you found a bug, have suggestions for improvement or feedback for us,
  then please write us a message in the dedicated <i>Feedback</i> channel <a href="https://discord.gg/AeGFarvQyk">on our Discord server</a>.
  </p>
- <p style="text-align: justify;">
  The first time you start [a new version] of QuerysAutoClicker on Windows, you will most likely get a warning.
  To start the program, click on <b>More info</b> and then on <b>Run anyway</b>. The reason for
  this warning is <a href="https://github.com/kwhat/jnativehook">JNativeHook</a>. JNativeHook is only used in the program to
  that the start/stop hotkey can also be recognized without the program having to be in the foreground or selected.
  </p>
- <p style="text-align: justify;">
  It is not recommended to set the click and write speed very high in the QuerysAutoClicker program,
  because the computer or the program cannot provide this performance. With AutoText it can happen that the constant key combinations
  other things happen or are opened. In the program, the speed set too high can be recognized by the red text.
  For <i>Speed</i>, the number turns red if the value is 200 or greater. At <i>interval</i>, the number of <i>milliseconds</i> turns red,
  if the total is 5 milliseconds or less.
  </p>
- <p style="text-align: justify;">
  The saved states are reset at program start if the <i>QuerysAutoClicker.ser</i> file is in "C:\Users\\{USER}\\"
  has been damaged or deleted. Saving states is currently only supported on Windows.
  </p>

## Installation

### Linux (Not bug free)

1. <p style="text-align: justify;">
   <b>Open Terminal</b>: <i>Strg</i> + <i>Alt</i> + <i>T</i>
   <br>
   Download the latest version of QuerysAutoClicker and install JDK 17 (Java Development Kit):
   </p>

   ```
   git clone https://github.com/getQueryString/QuerysAutoClicker.git
   sudo apt update
   sudo apt install openjdk-17-jdk
   ```
2. <p style="text-align: justify;">
   <a href="https://gluonhq.com/products/javafx/">Download and install JavaFX 17 or 19</a> for Linux. Type: <i>SDK</i>
   </p>
3. <p style="text-align: justify;">
   Start QuerysAutoClicker in the Terminal:
   </p>

   ```
   java --module-path /{PATH}/javafx-sdk-{VERSION}/lib --add-modules javafx.controls,javafx.media,javafx.fxml -jar
   /{PATH}/QuerysAutoClicker/lib/QuerysAutoClicker-1.0.0.jar
   ```
   <p style="text-align: justify;">
   or copy the edited command to a <i>Shell Script (.sh)</i> file and give that <i>Shell Script</i> file permission to
   that it can be run as a program:
   </p>

   ```
   chmod +x {NAME}.sh
   ```
   and run the _.sh_ file:
   ```
   ./{NAME}.sh
   ```

### macOS (Not bug free)

1. <p style="text-align: justify;">
   <b>Open Terminal</b>: <i>Command (⌘)</i> + <i>Spacebar</i> > search for <i>Terminal</i>.
   <br>
   Download the latest version of QuerysAutoClicker and install JDK 17 (Java Development Kit):
   </p>

   ```
   git clone https://github.com/getQueryString/QuerysAutoClicker.git
   jdk-17_macos-x64_bin.dmg   OR   jdk-17_macos-x64_bin.tar.gz
   ```

2. <p style="text-align: justify;">
   <a href="https://gluonhq.com/products/javafx/">Download and install JavaFX 17 or 19</a> for macOS. Type: <i>SDK</i>
   </p>
3. <p style="text-align: justify;">
   Permission Add <i>allow apps to control this computer</i>: <i>System Preferences</i> > <i>Security</i> > <i>
   Accessibility</i> > <i>Terminal</i>
   </p>
4. ```
   java --module-path /{PATH}/javafx-sdk-{VERSION}/lib --add-modules javafx.controls,javafx.media,javafx.fxml -jar
   /{PATH}/QuerysAutoClicker/lib/QuerysAutoClicker-1.0.0.jar
   ```
   <p style="text-align: justify;">
   or copy the edited command to a <i>Shell Script (.sh)</i> file and give that <i>Shell Script</i> file permission to
   that it can be run as a program:
   </p>

   ```
   chmod +x {NAME}.sh
   ```

   Run this _.sh_ file:
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
   <a href="https://www.oracle.com/java/technologies/downloads/#java17">Download and install JDK 17 or 19</a> (Java Development Kit) for Windows (For example: <i>x64 Installer</i> or <i>x64 MSI
    Installer</i>)
   </p>
2. <p style="text-align: justify;">
   <a href="https://api.github.com/repos/getQueryString/QuerysAutoClicker/releases/">Download the latest version of QuerysAutoClicker</a>, navigate to "\QuerysAutoClicker\lib\" and run the <i >QuerysAutoClicker-1.0.0.jar</i> file.
   </p>

## Compatibility

<p style="text-align: justify;">
<b>JDK</b>: <a href="https://www.oracle.com/java/technologies/javase/products-doc-jdk17certconfig.html">Oracle JDK 17</a> / <a href="https://www.oracle.com/java/technologies/javase/products-doc-jdk19certconfig.html">Oracle JDK 19</a>
<br>
<b>JavaFX</b>: In the <i>JavaFX 1.2 SDK Requirements</i> table <a href="https://www.oracle.com/java/technologies/javafx/system-requirements.html #javafxsdk">on Oracle's website</a>
only the lines <i>Processors</i>, <i>Operating System</i>, Memory and <i>Disk Space</i> are relevant.
</p>

## Contributors

**Founder and ideas:**
<br>
getQueryString, Jovan
<br>
<br>
**Design:**
<br>
Technocracy, getQueryString
<br>
<br>
**Programmed by:**
<br>
getQueryString

## Disclaimer

<p style="text-align: justify;">
In the event of damage or similar to the computer caused by the AutoClicker or AutoText, I assume <b>no liability</b>,
as using QuerysAutoClicker is to be used at your own risk. Can happen ...
</p>

- <p style="text-align: justify;">
  ... by the AutoClicker, that everything touched by the mouse pointer is clicked, which can result in
   that with careless use everything possible is clicked.
  </p>
- <p style="text-align: justify;">
  ... nothing due to the AutoText according to the current state of knowledge.</p>

## Copyright

<p style="text-align: justify;">
Copyright by getQueryString/Fin © All rights reserved. Download only on specified websites;
no content from the program may be used for any other purpose, modified or passed off as your own work or the like.
</p>