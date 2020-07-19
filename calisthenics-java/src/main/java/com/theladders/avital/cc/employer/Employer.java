package com.theladders.avital.cc.employer;

/**
 * @author sunjing
 */
public class Employer {

    private String name;

    private Employer() {
    }

    public static Employer create(String name) {
        Employer employer = new Employer();
        employer.name = name;
        return employer;
    }

    public String getName() {
        return name;
    }
}
