// Copyright© by Fin

package com.github.gqs.querysautoclicker.Utils;

public class UtilsOS {

    public enum OS {
        WINDOWS, LINUX, MACOS, INCOMPATIBLE
    }

    private static OS os = null;

    /**
     * Get operating system
     *
     * @return os
     */
    public static OS getOs() {
        if (os == null) {
            String operatingSystem = System.getProperty("os.name").toLowerCase();
            if (operatingSystem.contains("win"))
                os = OS.WINDOWS;
            else if (operatingSystem.contains("nux") || operatingSystem.contains("nix") || operatingSystem.contains("aix"))
                os = OS.LINUX;
            else if (operatingSystem.contains("mac") || operatingSystem.contains("osx") || operatingSystem.contains("darwin"))
                os = OS.MACOS;
            else
                os = OS.INCOMPATIBLE;
        }
        return os;
    }
}