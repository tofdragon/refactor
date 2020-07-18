package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunjing
 */
class JobApplications {

    private Map<String, List<JobApplication>> nameToJobApplications = new HashMap<>();

    private final FailedApplications failedApplications = new FailedApplications();

    void addJobApplication(JobSeeker jobSeeker, Job job, String employerName, LocalDate applicationTime)
            throws RequiresResumeForJReqJobException, InvalidResumeException {
        String resumeApplicantName = jobSeeker.getResume() == null ? null : jobSeeker.getResume().getName();

        if (JobType.JREQ == job.getJobType() && resumeApplicantName == null) {
            failedApplications.add(job, employerName, applicationTime);
            throw new RequiresResumeForJReqJobException();
        }

        if (JobType.JREQ == job.getJobType() && !resumeApplicantName.equals(jobSeeker.getName())) {
            throw new InvalidResumeException();
        }

        List<JobApplication> jobApplications = nameToJobApplications.get(jobSeeker.getName());
        if (jobApplications == null) {
            jobApplications = new ArrayList<>();
            nameToJobApplications.put(jobSeeker.getName(), jobApplications);
        }
        jobApplications.add(JobApplication.create(employerName, job, applicationTime));
    }

    List<JobApplication> get(String jobSeekerName) {
        return nameToJobApplications.get(jobSeekerName);
    }

    Map<String, List<JobApplication>> getNameToJobApplications() {
        return nameToJobApplications;
    }

    int getUnsuccessfulApplications(String employerName, String jobName) {
        return failedApplications.getUnsuccessfulApplications(employerName, jobName);
    }
}
