// Copyright© by Fin

package com.github.gqs.querysautoclicker.Personalization;

import java.io.Serializable;

public class Save implements Serializable {

    private final String key;
    private String stringValue;
    private boolean booleanValue;

    /**
     * Save a state of type String
     *
     * @param key
     * @param stringValue
     */
    public Save(String key, String stringValue) {
        this.key = key;
        this.stringValue = stringValue;
    }

    /**
     * Save a state of type boolean
     *
     * @param key
     * @param booleanValue
     */
    public Save(String key, boolean booleanValue) {
        this.key = key;
        this.booleanValue = booleanValue;
    }

    /**
     * @return stringValue
     */
    public String getStringValue() {
        return this.stringValue;
    }

    /**
     * @return booleanValue
     */
    public boolean getBooleanValue() {
        return this.booleanValue;
    }
}