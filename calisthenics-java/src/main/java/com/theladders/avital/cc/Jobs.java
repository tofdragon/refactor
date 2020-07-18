package com.theladders.avital.cc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjing
 */
final class Jobs {

    private List<Job> jobs;

    private Jobs() {
        jobs = new ArrayList<>();
    }

    static Jobs create(Job addJobs) {
        Jobs jobs = new Jobs();
        jobs.add(addJobs);
        return jobs;
    }

    boolean includeJob(Job otherJob) {
        return jobs.stream().filter(job -> job.equalsJob(otherJob)).findAny().isPresent();
    }

    void add(Job job) {
        this.jobs.add(job);
    }
}
