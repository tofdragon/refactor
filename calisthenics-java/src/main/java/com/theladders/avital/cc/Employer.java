package com.theladders.avital.cc;

/**
 * @author sunjing
 */
class Employer {

    private String name;

    private Employer() {
    }

    static Employer create(String name) {
        Employer employer = new Employer();
        employer.name = name;
        return employer;
    }

    String getName() {
        return name;
    }
}
