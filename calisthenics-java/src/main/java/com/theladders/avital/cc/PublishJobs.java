package com.theladders.avital.cc;

import java.util.HashMap;
import java.util.Map;

import com.theladders.avital.cc.exception.NotSupportedJobTypeException;

/**
 * @author sunjing
 */
final class PublishJobs {

    private Map<String, Jobs> employeeNameToJobs = new HashMap<>();

    void add(String employerName, Job job) throws NotSupportedJobTypeException {
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

    Jobs get(String employerName) {
        return employeeNameToJobs.get(employerName);
    }
}
