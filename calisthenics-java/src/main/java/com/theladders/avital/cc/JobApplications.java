package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunjing
 */
class JobApplications {

    private Map<String, List<JobApplication>> nameToJobApplications = new HashMap<>();

    void addJobApplication(String jobSeekerName, Job job, String employerName, LocalDate applicationTime) {
        List<JobApplication> jobApplications = nameToJobApplications.get(jobSeekerName);
        if (jobApplications == null) {
            jobApplications = new ArrayList<>();
            nameToJobApplications.put(jobSeekerName, jobApplications);
        }
        jobApplications.add(JobApplication.create(employerName, job, applicationTime));
    }

    List<JobApplication> get(String jobSeekerName) {
        return nameToJobApplications.get(jobSeekerName);
    }
}
