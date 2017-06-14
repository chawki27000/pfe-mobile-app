package com.dev.chawki.alpha.models;

/**
 * Created by ilyes on 6/14/17.
 */

public class Signe {
    private String name;
    private boolean isActive;

    public Signe(String name) {
        this.name = name;
    }

    public Signe(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
