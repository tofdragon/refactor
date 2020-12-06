package com.theladders.avital.cc.jobseeker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.theladders.avital.cc.job.Job;
import com.theladders.avital.cc.job.Jobs;

/**
 * @author sunjing
 */
public class JobSeeker {

    private String name;

    private Jobs savedJobs = new Jobs();

    private JobApplications applied = new JobApplications();

    private JobApplications failed = new JobApplications();

    public JobSeeker(String jobSeekerName) {
        this.name = jobSeekerName;
    }

    public String getName() {
        return name;
    }

    public Jobs getSavedJobs() {
        return savedJobs;
    }

    public JobApplications getApplied() {
        return applied;
    }

    public JobApplications getFailed() {
        return failed;
    }

    public void addSavedJob(Job job) {
        savedJobs.add(job);
    }

    public void addApplied(JobApplication jobApplication) {
        applied.add(jobApplication);
    }

    public void addFailed(JobApplication jobApplication) {
        failed.add(jobApplication);
    }

    public int getSuccessfulApplications(String employerName, String jobName) {
        return (int) getApplied().getJobApplications().stream()
                .filter(jobApplication -> jobApplication.getJob().getName().equals(jobName)
                        && jobApplication.getEmployerName().equals(employerName)).count();
    }

    public int getUnsuccessfulApplications(String employerName, String jobName) {
        return (int) getFailed().getJobApplications().stream().filter(jobApplication -> jobApplication.getJob().getName().equals(jobName)
                    && jobApplication.getEmployerName().equals(employerName)).count();
    }

    public long findApplicants(String jobName, LocalDate from, LocalDate to) {
            return getApplied().getJobApplications().stream().filter(jobApplication -> {
                List<Boolean> results = new ArrayList<>();
                if (jobName != null) {
                    results.add(jobApplication.getJob().getName().equals(jobName));
                }

                if (from != null) {
                    results.add(!from.isAfter(jobApplication.getApplicationTime()));
                }

                if (to != null) {
                    results.add(!to.isBefore(jobApplication.getApplicationTime()));
                }

                if (results.size() <= 0) {
                    return true;
                }

                return results.stream().filter(r -> !r).findAny().orElse(true);
            }).count();

    }
}
