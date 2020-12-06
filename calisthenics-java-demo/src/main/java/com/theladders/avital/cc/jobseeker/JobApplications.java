package com.theladders.avital.cc.jobseeker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunjing
 */
public class JobApplications {

    private List<JobApplication> jobApplications = new ArrayList<>();

    public void add(JobApplication jobApplication) {
        jobApplications.add(jobApplication);
    }

    public List<JobApplication> getJobApplications() {
        return Collections.unmodifiableList(jobApplications);
    }

    public boolean contains(JobApplication jobApplication) {
        return jobApplications.contains(jobApplication);
    }
}
