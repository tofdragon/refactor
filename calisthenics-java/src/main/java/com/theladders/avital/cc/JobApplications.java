package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.theladders.avital.cc.exception.InvalidResumeException;
import com.theladders.avital.cc.exception.RequiresResumeForJReqJobException;

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
            failedApplications.add(jobSeeker.getName(), job, employerName, applicationTime);
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
        jobApplications.add(JobApplication.create(jobSeeker.getName(), employerName, job, applicationTime));
    }

    List<JobApplication> get(String jobSeekerName) {
        return nameToJobApplications.get(jobSeekerName);
    }

    Map<String, List<JobApplication>> getNameToJobApplications() {
        return nameToJobApplications;
    }

    List<String> findApplicants(String jobName) {
        return this.findApplicants(jobName, null, null);
    }

    List<String> findApplicants(String jobName, LocalDate from) {
        return this.findApplicants(jobName, from, null);
    }

    List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<JobApplication>> set : getNameToJobApplications().entrySet()) {
            String applicant = set.getKey();
            List<JobApplication> jobs = set.getValue();
            boolean isAppliedThisDate = jobs.stream().anyMatch(job -> {
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
            });
            if (isAppliedThisDate) {
                result.add(applicant);
            }
        }
        return result;
    }

    List<JobApplication> findApplicants(LocalDate date) {
        List<JobApplication> result = new ArrayList<>();
        for (Map.Entry<String, List<JobApplication>> set : getNameToJobApplications().entrySet()) {
            List<JobApplication> jobs1 = set.getValue();
            List<JobApplication> found = jobs1.stream().filter(job ->
                    job.getApplicationTime().isEqual(date)).collect(Collectors.toList());
            result.addAll(found);
        }
        return result;
    }

    int getUnsuccessfulApplications(String employerName, String jobName) {
        return failedApplications.getUnsuccessfulApplications(employerName, jobName);
    }
}
