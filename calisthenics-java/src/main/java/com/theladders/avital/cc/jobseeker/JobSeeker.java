package com.theladders.avital.cc.jobseeker;

/**
 * @author sunjing
 */
public final class JobSeeker {

    private String name;

    private Resume resume;

    private JobSeeker() {
    }

    public static JobSeeker create(String name) {
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.name = name;
        return jobSeeker;
    }

    public static JobSeeker create(String name, String resumeName) {
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.name = name;
        jobSeeker.resume = Resume.create(resumeName);
        return jobSeeker;
    }

    public String getName() {
        return name;
    }

    private Resume getResume() {
        return resume;
    }

    private boolean hasResume() {
        return getResume() != null;
    }

    public boolean hasNotResume() {
        return !hasResume();
    }

    public String getResumeName() {
        return getResume().getName();
    }

    public boolean isNotJobSeekerResume() {
        if (hasNotResume()) {
            return true;
        }

        if (!getResumeName().equals(getName())) {
            return true;
        }

        return false;
    }
}
