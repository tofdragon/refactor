package com.theladders.avital.cc;

import java.util.List;

/**
 * @author sunjing
 */
final class Jobs {

    private List<Job> jobs;

    private Jobs() {
    }

    static Jobs create(List<Job> addJobs) {
        Jobs jobs = new Jobs();
        jobs.jobs = addJobs;
        return jobs;
    }

    boolean includeJob(Job otherJob) {
        return jobs.stream().filter(job -> job.equalsJob(otherJob)).findAny().isPresent();
    }
}
