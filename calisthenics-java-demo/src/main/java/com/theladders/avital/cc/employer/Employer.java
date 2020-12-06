package com.theladders.avital.cc.employer;

import com.theladders.avital.cc.job.Job;
import com.theladders.avital.cc.job.Jobs;

/**
 * @author sunjing
 */
public class Employer {

    private String name;

    private Jobs jobs = new Jobs();

    public Employer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equalsName(String name) {
        return getName().equals(name);
    }

    public Jobs getPublishedJobs() {
        return jobs;
    }

    public void addPublishedJob(Job job) {
        jobs.add(job);
    }
}
