package com.theladders.avital.cc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunjing
 */
final class PublishJobs {

    private Map<String, List<Job>> employeeNameToJobs = new HashMap<>();

    void add(String employerName, Job job) throws NotSupportedJobTypeException {
        if (!(JobType.JREQ == job.getJobType()) && !(JobType.ATS == job.getJobType())) {
            throw new NotSupportedJobTypeException();
        }

        List<Job> jobs = employeeNameToJobs.get(employerName);
        if (jobs == null) {
            jobs = new ArrayList<>();
            employeeNameToJobs.put(employerName, jobs);
        }
        jobs.add(job);
    }

    List<Job> get(String employerName) {
        return employeeNameToJobs.get(employerName);
    }
}
