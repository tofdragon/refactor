package com.theladders.avital.cc.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunjing
 */
public final class SaveJobs {

    private Map<String, List<Job>> jobSeekerNameToJob = new HashMap<>();

    public void add(String jobSeekerName, Job job) {
        List<Job> jobs = jobSeekerNameToJob.get(jobSeekerName);
        if (jobs == null) {
            jobs = new ArrayList<>();
            jobSeekerNameToJob.put(jobSeekerName, jobs);
        }
        jobs.add(job);
    }
}
