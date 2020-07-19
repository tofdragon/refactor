package com.theladders.avital.cc;

import java.time.LocalDate;

/**
 * @author sunjing
 */
final class FailedApplications {

    private final JobApplications failedApplications = new JobApplications();

    void add(String jobSeekerName, Job job, String employerName, LocalDate applicationTime) {
        failedApplications.add(JobApplication.create(jobSeekerName, employerName, job, applicationTime));
    }

    int getUnsuccessfulApplications(String employerName, String jobName) {
        return (int) failedApplications.getJobApplications().stream().filter(job -> job.getJob().getJobName().equals(jobName)
                && job.getEmployerName().equals(employerName)).count();
    }
}
