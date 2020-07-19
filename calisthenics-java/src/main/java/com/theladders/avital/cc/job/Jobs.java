package com.theladders.avital.cc.job;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjing
 */
public final class Jobs {

    private List<Job> jobs;

    private Jobs() {
        jobs = new ArrayList<>();
    }

    public static Jobs create(Job addJobs) {
        Jobs jobs = new Jobs();
        jobs.add(addJobs);
        return jobs;
    }

    public boolean includeJob(Job otherJob) {
        return jobs.stream().filter(job -> job.equalsJob(otherJob)).findAny().isPresent();
    }

    public void add(Job job) {
        this.jobs.add(job);
    }
}
