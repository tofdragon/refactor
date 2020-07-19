package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.List;

/**
 * @author sunjing
 */
public class JobSeekerJobApplication {

    private final JobApplications jobApplications = new JobApplications();

    void add(String jobSeekerName, Job job, String employerName, LocalDate applicationTime) {
        jobApplications.add(JobApplication.create(jobSeekerName, employerName, job, applicationTime));
    }

    int getUnsuccessfulApplications(String employerName, String jobName) { ;
        return jobApplications.countFindApplicantsBy(jobApplication -> jobApplication.getJob().getJobName().equals(jobName)
                && jobApplication.getEmployerName().equals(employerName));
    }

    public int getSuccessfulApplications(String employerName, String jobName) {
        return jobApplications.countFindApplicantsBy(jobApplication -> jobApplication.getEmployerName().equals(employerName)
                && jobApplication.getJob().getJobName().equals(jobName));
    }

    JobApplications get(String jobSeekerName) {
        return getJobApplications().findApplicantsBy(jobApplication -> jobApplication.getJobSeekerName().equals(jobSeekerName));
    }

    private JobApplications getJobApplications() {
        return jobApplications;
    }

    JobApplications findApplicants(LocalDate date) {
        return getJobApplications().findApplicantsBy(jobApplication -> jobApplication.getApplicationTime().isEqual(date));
    }

    List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        return getJobApplications().findApplicantsOfJobSeekerNameBy(jobApplication -> {
            if (jobName != null) {
                if (!jobApplication.getJob().getJobName().equals(jobName)) {
                    return false;
                }
            }

            if (from != null) {
                if (from.isAfter(jobApplication.getApplicationTime())) {
                    return false;
                }
            }

            if (to != null) {
                if (to.isBefore(jobApplication.getApplicationTime())) {
                    return false;
                }
            }

            return true;
        });
    }
}
