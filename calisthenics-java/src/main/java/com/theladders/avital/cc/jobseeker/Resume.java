package com.theladders.avital.cc.jobseeker;

/**
 * @author sunjing
 */
public final class Resume {

    private String name;

    private Resume() {
    }

    public static Resume create(String name) {
        Resume resume = new Resume();
        resume.name = name;
        return resume;
    }

    public String getName() {
        return name;
    }
}
