package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author sunjing
 */
final class JobApplication {

    private String employerName;

    private Job job;

    private LocalDate applicationTime;

    private JobApplication() {
    }

    static JobApplication create(String employerName, Job job, LocalDate applicationTime) {
        JobApplication jobApplication = new JobApplication();
        jobApplication.employerName = employerName;
        jobApplication.job = job;
        jobApplication.applicationTime = applicationTime;
        return jobApplication;
    }

    Job getJob() {
        return job;
    }

    LocalDate getApplicationTime() {
        return applicationTime;
    }

    public String getEmployerName() {
        return employerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JobApplication that = (JobApplication) o;
        return Objects.equals(employerName, that.employerName) &&
                Objects.equals(job, that.job) &&
                Objects.equals(applicationTime, that.applicationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employerName, job, applicationTime);
    }
}
