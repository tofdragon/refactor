package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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

    public int getSuccessfulApplications(String employerName, String jobName) {
        return (int)getJobApplications().getJobApplications().stream().filter(job ->
                job.getEmployerName().equals(employerName) && job.getJob().getJobName().equals(jobName)).count();
    }

    JobApplications get(String jobSeekerName) {
        JobApplications foundJobApplications = new JobApplications();
        for (JobApplication jobApplication : jobApplications.getJobApplications()) {
            if (jobApplication.getJobSeekerName().equals(jobSeekerName)) {
                foundJobApplications.add(jobApplication);
            }
        }
        return foundJobApplications;
    }

    private JobApplications getJobApplications() {
        return jobApplications;
    }

    List<JobApplication> findApplicants(LocalDate date) {
        return getJobApplications().getJobApplications().stream().filter(job ->
                job.getApplicationTime().isEqual(date)).collect(toList());
    }

    List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        return getJobApplications().getJobApplications().stream().filter(job -> {
            if (jobName != null) {
                if (!job.getJob().getJobName().equals(jobName)) {
                    return false;
                }
            }

            if (from != null) {
                if (from.isAfter(job.getApplicationTime())) {
                    return false;
                }
            }

            if (to != null) {
                if (to.isBefore(job.getApplicationTime())) {
                    return false;
                }
            }

            return true;
        }).map(jobApplication -> jobApplication.getJobSeekerName()).collect(toList());

    }
}
