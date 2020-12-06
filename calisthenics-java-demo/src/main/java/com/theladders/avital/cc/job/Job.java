package com.theladders.avital.cc.job;

import java.util.Objects;

/**
 * @author sunjing
 */
public class Job {

    private String name;

    private JobType type;

    private Job() {
    }

    public static Job create(String jobName, JobType jobType) {
        Job job = new Job();
        job.name = jobName;
        job.type = jobType;
        return job;
    }

    public String getName() {
        return name;
    }

    public JobType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Job job = (Job) o;
        return Objects.equals(name, job.name) && type == job.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
