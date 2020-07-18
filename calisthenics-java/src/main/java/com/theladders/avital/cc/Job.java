package com.theladders.avital.cc;

import java.util.Objects;

/**
 * @author sunjing
 */
final class Job {

    private String jobName;

    private JobType jobType;

    private Job() {
    }

    static Job create(String jobName, JobType jobType) {
        Job job = new Job();
        job.jobName = jobName;
        job.jobType = jobType;
        return job;
    }

    public String getJobName() {
        return jobName;
    }

    public JobType getJobType() {
        return jobType;
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
        return Objects.equals(jobName, job.jobName) &&
                jobType == job.jobType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobName, jobType);
    }
}
