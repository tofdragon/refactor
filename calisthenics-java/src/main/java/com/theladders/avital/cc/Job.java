package com.theladders.avital.cc;

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
}
