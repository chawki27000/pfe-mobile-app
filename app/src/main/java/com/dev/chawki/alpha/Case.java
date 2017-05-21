package com.dev.chawki.alpha;

import java.util.ArrayList;


public class Case {
    private int age;
    private String type;
    private String gender;

    public Case(int age, String type, String gender) {
        this.age = age;
        this.type = type;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    private static int lastContactId = 0;

    public static ArrayList<Case> createCaseList(int numCase) {
        ArrayList<Case> cases = new ArrayList<Case>();

        for (int i = 1; i <= numCase; i++) {
            cases.add(new Case(12, "Year","Mal"));
        }

        return cases;
    }
}
