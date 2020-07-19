package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.theladders.avital.cc.exception.InvalidResumeException;
import com.theladders.avital.cc.exception.RequiresResumeForJReqJobException;

import static java.util.stream.Collectors.toList;

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
        return successApplications.getJobApplications().getJobApplications().stream().filter(job ->
                    job.getEmployerName().equals(employerName) && job.getJob().getJobName().equals(jobName)).collect(Collectors.toList()).size();
    }

    List<String> findApplicants(String jobName) {
        return this.findApplicants(jobName, null, null);
    }

    List<String> findApplicants(String jobName, LocalDate from) {
        return this.findApplicants(jobName, from, null);
    }

    List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        return successApplications.getJobApplications().getJobApplications().stream().filter(job -> {
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

    List<JobApplication> findApplicants(LocalDate date) {
        return successApplications.getJobApplications().getJobApplications().stream().filter(job ->
                    job.getApplicationTime().isEqual(date)).collect(toList());
    }

    int getUnsuccessfulApplications(String employerName, String jobName) {
        return failedApplications.getUnsuccessfulApplications(employerName, jobName);
    }
}
