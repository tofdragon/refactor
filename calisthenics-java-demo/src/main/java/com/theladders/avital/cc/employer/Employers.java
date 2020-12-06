package com.theladders.avital.cc.employer;

import java.util.ArrayList;
import java.util.List;

import com.theladders.avital.cc.exception.NotSupportedJobTypeException;
import com.theladders.avital.cc.job.Job;
import com.theladders.avital.cc.job.JobType;
import com.theladders.avital.cc.job.Jobs;

/**
 * @author sunjing
 */
public class Employers {

    private final List<Employer> employers = new ArrayList<>();

    public void addPublishedJobs(String employerName, String jobName, JobType jobType)
            throws NotSupportedJobTypeException {
        if (notSupportedJobType(jobType)) {
            throw new NotSupportedJobTypeException();
        }

        addJobs(employerName, jobName, jobType);
    }

    private void addJobs(String employerName, String jobName, JobType jobType) {
        Employer foundEmployer = getEmployerByName(employerName);
        if (foundEmployer == null) {
            foundEmployer = new Employer(employerName);
            employers.add(foundEmployer);
        }
        foundEmployer.addPublishedJob(Job.create(jobName, jobType));
    }

    private boolean notSupportedJobType(JobType jobType) {
        return jobType != JobType.JReq && jobType != JobType.ATS;
    }

    public Jobs getPublishedJobs(String employerName) {
        return getEmployerByName(employerName).getPublishedJobs();
    }

    private Employer getEmployerByName(String employerName) {
        return employers.stream().filter(employer -> employer.equalsName(employerName)).findAny().orElse(null);
    }
}
