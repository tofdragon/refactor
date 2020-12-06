package com.theladders.avital.cc.jobseeker;

import java.time.LocalDate;
import java.util.Objects;

import com.theladders.avital.cc.job.Job;

/**
 * @author sunjing
 */
public class JobApplication {

    private Job job;

    private Application application;

    private JobApplication() {
    }

    public static JobApplication create(Job job, LocalDate applicationTime, String employerName) {
        JobApplication jobApplication = new JobApplication();
        jobApplication.job = job;
        jobApplication.application = Application.create(applicationTime, employerName);
        return jobApplication;
    }

    public Job getJob() {
        return job;
    }

    public LocalDate getApplicationTime() {
        return application.getApplicationTime();
    }

    public String getEmployerName() {
        return application.getEmployerName();
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
        return Objects.equals(job, that.job) &&
                Objects.equals(getApplicationTime(), that.getApplicationTime()) &&
                Objects.equals(getEmployerName(), that.getEmployerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, getApplicationTime(), getEmployerName());
    }
}
