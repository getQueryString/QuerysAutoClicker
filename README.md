<img src="QuerysAutoClicker_Icon+QAC_Logo.png" alt="QuerysAutoClicker logo" style="width: 25%;">

# QuerysAutoClicker (QAC)

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

Thanks to all the people who helped me while I was programming QuerysAutoClicker.
Whether it was a feedback or a suggestion, it helped make QuerysAutoClicker nicer and better.
Since this is my first big project and I'm not a professional programmer, I often got negative feedback, but I was happy to improve.
I always gratefully accepted this help. To all the people out there who also want to program:
Don't be discouraged if you can't get your program to work on the first try, or if someone tells you that your programming style isn't the
best.
Ask if you have any questions. There are no stupid questions, only stupid answers.
Thanks!

## QuerysAutoClicker

QuerysAutoClicker is programmed in the programming language <i>Java</i> and in the markup language <i>CSS</i>
Open source program intended to simulate clicking a mouse or typing on a keyboard.

## Properties

QuerysAutoClicker is not just an AutoClicker with which you can get a very high number of clicks in Minecraft, for example
can have, there is also an AutoText function, with which the entered text can be automatically rewritten.
Not only the click or write speed can be changed ...
<br>
<br>
QuerysAutoClicker was not designed like other autoclickers from the web - it can be customized at will:

- Click and warning sounds can be switched on and off
- Choice of 8 designs
- Choice of 5 languages:
    - English
    - French
    - German
    - Russian
    - Spanish
- If anything is unclear, _Tips_ can be switched on and off. If the tips are activated, short help texts appear when you use
  mouse over the elements.
- Automatic update search when starting the program can be switched on and off
- Always put in the foreground:
    - **Green pushpin**: Always on top (Always on top of all other windows)
    - **Red pushpin**: Behind other windows as soon as others window can be dragged over the QuerysAutoClicker window.

- All states of the listed adjustable functions are automatically saved in the _QuerysAutoClicker.ser_ file.

## Notes

- If you found a bug, have suggestions for improvement or feedback for us, then please write us a message in the
  dedicated _Feedback_ channel <a href="https://discord.gg/AeGFarvQyk">on our Discord server</a>.
    - **Linux bugs known to us**:
        - Start/Stop hotkey must be reset once before the first start
        - Click position does not work
        - AutoText only works with _insert text_ and _line for
          Line_
    - Us **known errors with macOS**:
        - AutoText only works with _insert text_ and _line for
          Line_
- QuerysAutoClicker only requires an internet connection for the automatic update search when the program starts.
- When starting [a new version] of QuerysAutoClicker for the first time on Windows, a warning may be displayed. To start the program, click
  on **More information** and then on **Run anyway**. The reason for
  this warning is <a href="https://github.com/kwhat/jnativehook">JNativeHook</a>. JNativeHook is only used in the program for that
  the start/stop hotkey can also be recognized without the program having to be in the foreground or selected.
- It is not recommended to set the click and write speed very high in QuerysAutoClicker, because the computer or
  the program cannot provide this service. In the program, the speed set too high can be recognized by the red text. For _speed_, the number
  turns red when the value is 200 or greater. For _interval_, the number of _milliseconds_ turns red if the total is 5 milliseconds or less.
    - With the AutoClicker it can happen that everything that is accidentally touched by the mouse pointer is clicked.
    - Due to the AutoText it can happen that if the writing speed is set too high, the constant key combinations do unexpected things or
      other things are opened.
- The saved states are reset at program start if the _QuerysAutoClicker.ser_ file has been damaged or deleted.
- QuerysAutoClicker accesses the _QuerysAutoClicker.ser_ file in the file path where it was started. Becomes
  If QuerysAutoClicker is started in a different path afterwards, a new _QuerysAutoClicker.ser_ file will be created.

## Installation

### Linux

1. (Open Terminal: _Ctrl_ + _Alt_ + _T_)
   <br>
   Download the _QuerysAutoClicker-1.0.1.tar_ / _.zip_ file of the latest version
   from <a href="https://github.com/getQueryString/QuerysAutoClicker/releases">QuerysAutoClicker</a> and unzip it.
2. <a href="https://www.oracle.com/java/technologies/downloads/#java17">Download JDK 17 (Java Development Kit) for Linux</a> and
   install or install in terminal:
   ```
   sudo apt update
   sudo apt install openjdk-17-jdk
   ```
3. <a href="https://gluonhq.com/products/javafx/">Download JavaFX 19 for Linux</a> and install. Type: _SDK_
4. Start QuerysAutoClicker in the terminal:
   ```
   java --module-path /{PATH}/javafx-sdk-19/lib --add-modules javafx.controls,javafx.media,javafx.fxml -jar /{PATH}/QuerysAutoClicker/lib/QuerysAutoClicker-1.0.1 .jar
   ```
   or copy the edited command to a _Shell Script (.sh)_ file and give permission to that _Shell Script_ file
   give permission to run as a program:
   ```
   chmod +x {NAME}.sh
   ```
   and run the _.sh_ file:
   ```
   ./{NAME}.sh
   ```

### macOS

1. (Open Terminal: _Command (⌘)_ + _Spacebar_ > search for _Terminal_)
   <br>
   Download the _QuerysAutoClicker-1.0.1.tar_ / _.zip_ file of the latest version
   from <a href="https://github.com/getQueryString/QuerysAutoClicker/releases">QuerysAutoClicker</a> and unzip it.
2. <a href="https://www.oracle.com/java/technologies/downloads/#java17">Download JDK 17 (Java Development Kit) for macOS</a> and
   install or install in terminal:
   ```
   jdk-17_macos-x64_bin.dmg OR jdk-17_macos-x64_bin.tar.gz
   ```
3. <a href="https://gluonhq.com/products/javafx/">Download JavaFX 19 for macOS</a> and install. Type: _SDK_
4. Add permission _Apps can control this computer_: _System Preferences_ > _Security_ > _
   Accessibility_ > _Terminal_
5. Start QuerysAutoClicker in the terminal:
   ```
   java --module-path /{PATH}/javafx-sdk-19/lib --add-modules javafx.controls,javafx.media,javafx.fxml -jar /{PATH}/QuerysAutoClicker/lib/QuerysAutoClicker-1.0.1 .jar
   ```
   or copy the edited command to a _Shell Script (.sh)_ file and give permission to that _Shell Script_ file
   give permission to run as a program:
   ```
   chmod +x {NAME}.sh
   ```
   Run this _.sh_ file:<br>
   Bourne shell:
   ```
   sh {NAME}.sh
   ```
   bash:
   ```
   bash {NAME}.sh
   ```

### Windows

1. <a href="https://www.oracle.com/java/technologies/downloads/#java17">Download JDK 17 (Java Development Kit) for Windows</a>
   and install. (For example: _x64 Installer_ or _x64 MSI Installer_)
2. Download the _QuerysAutoClicker-1.0.1.tar_ / _.zip_ file of the latest version
   from <a href="https://github.com/getQueryString/QuerysAutoClicker/releases">QuerysAutoClicker</a> and unzip it.
3. Run the _QuerysAutoClicker-1.0.1.jar_ file in "\QuerysAutoClicker\lib\".

## Compatibility

<b>JDK</b>: <a href="https://www.oracle.com/java/technologies/javase/products-doc-jdk17certconfig.html">Oracle JDK 17</a>
/ <a href="https://www.oracle.com/java/technologies/javase/products-doc-jdk19certconfig.html">Oracle JDK 19</a>
<br>
<b>JavaFX</b>: In the <i>JavaFX 1.2 SDK Requirements</i>
table <a href="https://www.oracle.com/java/technologies/javafx/system-requirements.html #javafxsdk">on Oracle's website</a>
only the lines <i>Processors</i>, <i>Operating System</i>, Memory and <i>Disk Space</i> are relevant.

## Contributors

**Founders and ideas:**
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

In the case of damage or similar to the computer caused by the AutoClicker or AutoText, I assume **no liability**,
as QuerysAutoClicker is to be used at your own risk.

## Copyright

Copyright by getQueryString/Fin © All rights reserved. Download only on specified websites;
no content from the program may be used for any other purpose, modified or passed off as your own work or the like.