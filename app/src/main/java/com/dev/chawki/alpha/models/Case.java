package com.dev.chawki.alpha.models;

import java.util.ArrayList;


public class Case {
    private int age;
    private String type;
    private String gender;

    public static final String MALE = "MALE";
    public static final String FEMALE = "FEMALE";

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
            if (i % 2 == 0) {
                cases.add(new Case(12, "Year", MALE));
            } else {
                cases.add(new Case(12, "Year", FEMALE));
            }
        }

        return cases;
    }
}
