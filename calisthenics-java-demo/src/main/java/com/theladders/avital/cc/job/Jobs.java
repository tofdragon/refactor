package com.theladders.avital.cc.job;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjing
 */
public class Jobs {

    private List<Job> jobs = new ArrayList<>();

    public boolean contains(Job job) {
        return jobs.contains(job);
    }

    public void add(Job job) {
        jobs.add(job);
    }
}
