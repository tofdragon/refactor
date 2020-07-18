package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjing
 */
final class FailedApplications {

    private final List<JobApplication> failedApplications = new ArrayList<>();

    void add(Job job, String employerName, LocalDate applicationTime) {
        failedApplications.add(JobApplication.create(employerName, job, applicationTime));
    }

    int getUnsuccessfulApplications(String employerName, String jobName) {
        return (int) failedApplications.stream().filter(job -> job.getJob().getJobName().equals(jobName)
                && job.getEmployerName().equals(employerName)).count();
    }
}
