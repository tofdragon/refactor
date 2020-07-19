package com.theladders.avital.cc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author sunjing
 */
public final class JobApplications {

    private List<JobApplication> jobApplications;

    public JobApplications() {
        jobApplications = new LinkedList<>();
    }

    void add(JobApplication jobApplication) {
        this.jobApplications.add(jobApplication);
    }

    public boolean equalsTo(JobApplications that) {
        return Objects.equals(jobApplications, that.jobApplications);
    }

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }
}
