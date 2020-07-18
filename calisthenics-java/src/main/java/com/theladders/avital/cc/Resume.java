package com.theladders.avital.cc;

/**
 * @author sunjing
 */
final class Resume {

    private String name;

    private Resume() {
    }

    static Resume create(String name) {
        Resume resume = new Resume();
        resume.name = name;
        return resume;
    }

    String getName() {
        return name;
    }
}
