package com.theladders.avital.cc.jobseeker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.theladders.avital.cc.exception.InvalidResumeException;
import com.theladders.avital.cc.job.Job;
import com.theladders.avital.cc.job.JobType;
import com.theladders.avital.cc.job.Jobs;

/**
 * @author sunjing
 */
public class JobSeekers {

    private final List<JobSeeker> jobSeekers = new ArrayList<>();

    public void addSavedJobs(String jobSeekerName, String jobName, JobType jobType) {
        getJobSeeker(jobSeekerName).addSavedJob(Job.create(jobName, jobType));
    }

    private JobSeeker getJobSeeker(String jobSeekerName) {
        JobSeeker foundJobSeeker = jobSeekers.stream().filter(jobSeeker -> jobSeeker.getName().equals(jobSeekerName)).findAny().orElse(null);
        if (foundJobSeeker == null) {
            foundJobSeeker = new JobSeeker(jobSeekerName);
            jobSeekers.add(foundJobSeeker);
        }
        return foundJobSeeker;
    }

    public Jobs getSavedJobs(String jobSeekerName) {
        return getJobSeeker(jobSeekerName).getSavedJobs();
    }

    public void addFailed(String employerName, String jobName, JobType jobType, String jobSeekerName, LocalDate applicationTime) {
        getJobSeeker(jobSeekerName).addFailed(JobApplication.create(Job.create(jobName, jobType), applicationTime, employerName));
    }

    public int getUnsuccessfulApplications(String employerName, String jobName) {
        long count = 0;
        for (JobSeeker jobSeeker : jobSeekers) {
            count +=  jobSeeker.getUnsuccessfulApplications(employerName, jobName);
        }
        return (int) count;
    }

    public void addApplied(String employerName, String jobName, JobType jobType, String jobSeekerName, String resumeApplicantName, LocalDate applicationTime) throws InvalidResumeException {
        if (jobType == JobType.JReq && !resumeApplicantName.equals(jobSeekerName)) {
            throw new InvalidResumeException();
        }
        getJobSeeker(jobSeekerName).addApplied(JobApplication.create(Job.create(jobName, jobType), applicationTime, employerName));
    }

    public JobApplications getAppliedJobs(String jobSeekerName) {
        return getJobSeeker(jobSeekerName).getApplied();
    }

    public List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        List<String> result = new ArrayList<String>() {};

        for (JobSeeker jobSeeker : jobSeekers) {
            long count = jobSeeker.findApplicants(jobName, from, to);
            if (count > 0) {
                result.add(jobSeeker.getName());
            }
        }

        return result;
    }

    public int getSuccessfulApplications(String employerName, String jobName) {
        int result = 0;
        for (JobSeeker jobSeeker : jobSeekers) {
            result += jobSeeker.getSuccessfulApplications(employerName,jobName);
        }
        return result;
    }

    public List<JobSeeker> getJobSeekers() {
        return jobSeekers;
    }
}
