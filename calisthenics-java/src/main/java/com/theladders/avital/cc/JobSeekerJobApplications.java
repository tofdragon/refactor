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
class JobSeekerJobApplications {

    private Map<String, JobApplications> nameToJobApplications = new HashMap<>();

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

        JobApplications jobApplications1 = nameToJobApplications.get(jobSeeker.getName());
        if (jobApplications1 == null) {
            jobApplications1 = new JobApplications();
            nameToJobApplications.put(jobSeeker.getName(), jobApplications1);
        }
        jobApplications1.add(JobApplication.create(jobSeeker.getName(), employerName, job, applicationTime));
    }

    JobApplications get(String jobSeekerName) {
        return nameToJobApplications.get(jobSeekerName);
    }

    private Map<String, JobApplications> getNameToJobApplications() {
        return nameToJobApplications;
    }

    public int getSuccessfulApplications(String employerName, String jobName) {
        int result = 0;
        for (Map.Entry<String, JobApplications> set : getNameToJobApplications().entrySet()) {
            JobApplications jobs = set.getValue();

            result += jobs.getJobApplications().stream().anyMatch(job -> job.getEmployerName().equals(employerName) && job.getJob().getJobName().equals(jobName)) ? 1 : 0;
        }
        return result;
    }

    List<String> findApplicants(String jobName) {
        return this.findApplicants(jobName, null, null);
    }

    List<String> findApplicants(String jobName, LocalDate from) {
        return this.findApplicants(jobName, from, null);
    }

    List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, JobApplications> set : getNameToJobApplications().entrySet()) {
            String applicant = set.getKey();
            JobApplications jobs = set.getValue();
            boolean isAppliedThisDate = jobs.getJobApplications().stream().anyMatch(job -> {
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
        for (Map.Entry<String, JobApplications> set : getNameToJobApplications().entrySet()) {
            JobApplications jobs1 = set.getValue();
            List<JobApplication> found = jobs1.getJobApplications().stream().filter(job ->
                    job.getApplicationTime().isEqual(date)).collect(Collectors.toList());
            result.addAll(found);
        }
        return result;
    }

    int getUnsuccessfulApplications(String employerName, String jobName) {
        return failedApplications.getUnsuccessfulApplications(employerName, jobName);
    }
}
