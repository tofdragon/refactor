package com.theladders.avital.cc.job;

import java.util.HashMap;
import java.util.Map;

import com.theladders.avital.cc.exception.NotSupportedJobTypeException;

/**
 * @author sunjing
 */
public final class PublishJobs {

    private Map<String, Jobs> employeeNameToJobs = new HashMap<>();

    public void add(String employerName, Job job) throws NotSupportedJobTypeException {
        if (!(JobType.JREQ == job.getJobType()) && !(JobType.ATS == job.getJobType())) {
            throw new NotSupportedJobTypeException();
        }

        Jobs jobs = employeeNameToJobs.get(employerName);
        if (jobs == null) {
            jobs = Jobs.create(job);
            employeeNameToJobs.put(employerName, jobs);
        }
        jobs.add(job);
    }

    public Jobs get(String employerName) {
        return employeeNameToJobs.get(employerName);
    }
}
