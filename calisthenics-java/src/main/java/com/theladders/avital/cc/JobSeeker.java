package com.theladders.avital.cc;

/**
 * @author sunjing
 */
final class JobSeeker {

    private String name;

    private Resume resume;

    private JobSeeker() {
    }

    static JobSeeker create(String name) {
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.name = name;
        return jobSeeker;
    }

    static JobSeeker create(String name, String resumeName) {
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.name = name;
        jobSeeker.resume = Resume.create(resumeName);
        return jobSeeker;
    }

    String getName() {
        return name;
    }

    Resume getResume() {
        return resume;
    }

}