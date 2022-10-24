<p style="text-align: center;">
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
    - **Red pushpin**: Behind other windows as soon as others
      window can be dragged over the QuerysAutoClicker window

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
- When starting [a new version] of QuerysAutoClicker for the first time on Windows, a warning will very likely be displayed. about that
  To be able to start the program, click on **More information** and then on **Run anyway**. The reason for
  this warning is <a href="https://github.com/kwhat/jnativehook">JNativeHook</a>. JNativeHook is only used in the program for that
  the start/stop hotkey can also be recognized without the program having to be in the foreground or selected.
- It is not recommended to set the click and write speed very high in the QuerysAutoClicker program, since the computer or
  the program cannot provide this service. With AutoText, it can happen that the constant key combinations cause other
  things happen or are opened. In the program, the speed set too high can be recognized by the red text. at
  _Speed_ the number turns red when the value is 200 or higher. At _interval_, the number of _milliseconds_ turns red,
  if the total is 5 milliseconds or less.
- The saved states are reset at program start if the _QuerysAutoClicker.ser_ file
  has been damaged or deleted.

## Installation

### Linux

1. (Open Terminal: _Ctrl_ + _Alt_ + _T_)
   <br>
   Download and unzip the QuerysAutoClicker-1.0.1.tar / .zip file of the latest version of QuerysAutoClicker here or download in terminal:
   ```
   git clone https://github.com/getQueryString/QuerysAutoClicker.git
   ```
   and JDK 17 (Java Development Kit) <a href="https://www.oracle.com/java/technologies/downloads/#java17">download here</a> and
   install or install in Terminal:
   ```
   sudo apt update
   sudo apt install openjdk-17-jdk
   ```
2. Download and install <a href="https://gluonhq.com/products/javafx/">JavaFX 19</a> for Linux. Type: _SDK_
3. Start QuerysAutoClicker in the Terminal:
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
   Download and unzip the _QuerysAutoClicker-1.0.1.tar_ / _.zip_ file of the latest
   version of QuerysAutoClicker <a href="https://github.com/getQueryString/QuerysAutoClicker/releases">here</a>
   or download in Terminal:
   ```
   git clone https://github.com/getQueryString/QuerysAutoClicker.git
   ```
   and JDK 17 (Java Development Kit) <a href="https://www.oracle.com/java/technologies/downloads/#java17">download here</a> and
   install or install in Terminal:
   ```
   jdk-17_macos-x64_bin.dmg OR jdk-17_macos-x64_bin.tar.gz
   ```
2. Download and install <a href="https://gluonhq.com/products/javafx/">JavaFX 19</a> for macOS. Type: _SDK_
3. Add permission _Apps can control this computer_: _System Preferences_ > _Security_ > _
   Accessibility_ > _Terminal_
4. Start QuerysAutoClicker in the Terminal:
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

1. Download <a href="https://www.oracle.com/java/technologies/downloads/#java17">JDK 17</a> (Java Development Kit) for Windows
   and install (For example: _x64 Installer_ or _x64 MSI Installer_)
2. Download and unzip the _QuerysAutoClicker-1.0.1.tar_ / _.zip_ file of the latest
   Version of QuerysAutoClicker <a href="https://github.com/getQueryString/QuerysAutoClicker/releases">here</a>.
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

- The AutoClicker can cause everything touched by the mouse pointer to be clicked.
- According to the current state of knowledge, nothing can happen with the AutoText.

## Copyright

Copyright by getQueryString/Fin © All rights reserved. Download only on specified websites;
no content from the program may be used for any other purpose, modified or passed off as your own work or the like.