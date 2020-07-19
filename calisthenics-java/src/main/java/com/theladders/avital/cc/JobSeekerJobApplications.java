package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.List;

import com.theladders.avital.cc.exception.InvalidResumeException;
import com.theladders.avital.cc.exception.RequiresResumeForJReqJobException;

/**
 * @author sunjing
 */
class JobSeekerJobApplications {

    private final JobSeekerJobApplication successApplications = new JobSeekerJobApplication();

    private final JobSeekerJobApplication failedApplications = new JobSeekerJobApplication();

    void addJobApplication(JobSeeker jobSeeker, Job job, String employerName, LocalDate applicationTime)
            throws RequiresResumeForJReqJobException, InvalidResumeException {
        String resumeApplicantName = jobSeeker.getResume() == null ? null : jobSeeker.getResume().getName();

        if (JobType.JREQ == job.getJobType() && resumeApplicantName == null) {
            failedApplications.add(jobSeeker.getName(), job, employerName, applicationTime);
            throw new RequiresResumeForJReqJobException();
        }

        if (JobType.JREQ == job.getJobType() && !resumeApplicantName.equals(jobSeeker.getName())) {
            throw new InvalidResumeException();
        }

        successApplications.add(jobSeeker.getName(), job, employerName, applicationTime);
    }

    JobApplications get(String jobSeekerName) {
        return successApplications.get(jobSeekerName);
    }

    public int getSuccessfulApplications(String employerName, String jobName) {
        return successApplications.getSuccessfulApplications(employerName, jobName);
    }

    List<String> findApplicants(String jobName) {
        return this.findApplicants(jobName, null, null);

    }

    List<String> findApplicants(String jobName, LocalDate from) {
        return this.findApplicants(jobName, from, null);
    }

    List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        return this.successApplications.findApplicants(jobName, from, to);
    }

    JobApplications findApplicants(LocalDate date) {
        return successApplications.findApplicants(date);
    }

    int getUnsuccessfulApplications(String employerName, String jobName) {
        return failedApplications.getUnsuccessfulApplications(employerName, jobName);
    }
}
