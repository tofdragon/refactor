package com.theladders.avital.cc.jobapplication;

import java.time.LocalDate;
import java.util.List;

import com.theladders.avital.cc.exception.InvalidResumeException;
import com.theladders.avital.cc.exception.RequiresResumeForJReqJobException;
import com.theladders.avital.cc.job.Job;
import com.theladders.avital.cc.job.JobType;
import com.theladders.avital.cc.jobseeker.JobSeeker;

/**
 * @author sunjing
 */
public class JobSeekerJobApplications {

    private final JobSeekerJobApplication successApplications = new JobSeekerJobApplication();

    private final JobSeekerJobApplication failedApplications = new JobSeekerJobApplication();

    public void addJobApplication(JobSeeker jobSeeker, Job job, String employerName, LocalDate applicationTime)
            throws RequiresResumeForJReqJobException, InvalidResumeException {
        if (JobType.JREQ == job.getJobType() && jobSeeker.hasNotResume()) {
            failedApplications.add(jobSeeker.getName(), job, employerName, applicationTime);
            throw new RequiresResumeForJReqJobException();
        }

        if (JobType.JREQ == job.getJobType() && jobSeeker.isNotJobSeekerResume()) {
            throw new InvalidResumeException();
        }

        successApplications.add(jobSeeker.getName(), job, employerName, applicationTime);
    }

    public JobApplications get(String jobSeekerName) {
        return successApplications.get(jobSeekerName);
    }

    public int getSuccessfulApplications(String employerName, String jobName) {
        return successApplications.getSuccessfulApplications(employerName, jobName);
    }

    public List<String> findApplicants(String jobName) {
        return this.findApplicants(jobName, null, null);

    }

    public List<String> findApplicants(String jobName, LocalDate from) {
        return this.findApplicants(jobName, from, null);
    }

    public List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        return this.successApplications.findApplicants(jobName, from, to);
    }

    public JobApplications findApplicants(LocalDate date) {
        return successApplications.findApplicants(date);
    }

    public int getUnsuccessfulApplications(String employerName, String jobName) {
        return failedApplications.getUnsuccessfulApplications(employerName, jobName);
    }
}
