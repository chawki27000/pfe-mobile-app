package com.dev.chawki.alpha.models;

/**
 * Created by ilyes on 6/13/17.
 */

public class Medicament {
    private String name;
    private int quantity;

    public Medicament(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
