package com.theladders.avital.cc;

import java.time.LocalDate;

/**
 * @author sunjing
 */
public class JobSeekerJobApplication {

    private final JobApplications jobApplications = new JobApplications();

    void add(String jobSeekerName, Job job, String employerName, LocalDate applicationTime) {
        jobApplications.add(JobApplication.create(jobSeekerName, employerName, job, applicationTime));
    }

    int getUnsuccessfulApplications(String employerName, String jobName) {
        return (int) jobApplications.getJobApplications().stream().filter(job -> job.getJob().getJobName().equals(jobName)
                && job.getEmployerName().equals(employerName)).count();
    }
}
