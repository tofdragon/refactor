package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.List;

import com.theladders.avital.cc.employer.Employer;
import com.theladders.avital.cc.exception.InvalidResumeException;
import com.theladders.avital.cc.exception.NotSupportedJobTypeException;
import com.theladders.avital.cc.exception.RequiresResumeForJReqJobException;
import com.theladders.avital.cc.export.ExportType;
import com.theladders.avital.cc.export.Exporter;
import com.theladders.avital.cc.job.Job;
import com.theladders.avital.cc.job.Jobs;
import com.theladders.avital.cc.job.PublishJobs;
import com.theladders.avital.cc.job.SaveJobs;
import com.theladders.avital.cc.jobapplication.JobApplications;
import com.theladders.avital.cc.jobapplication.JobSeekerJobApplications;
import com.theladders.avital.cc.jobseeker.JobSeeker;

/**
 * @author sunjing
 */
public final class Application {

    private final PublishJobs publishJobs = new PublishJobs();

    private final SaveJobs saveJobs = new SaveJobs();

    private final JobSeekerJobApplications jobSeekerJobApplications = new JobSeekerJobApplications();

    void apply(Employer employer, Job job, JobSeeker jobSeeker, LocalDate applicationTime)
            throws RequiresResumeForJReqJobException, InvalidResumeException {
        jobSeekerJobApplications.addJobApplication(jobSeeker, job, employer.getName(), applicationTime);
    }

    void save(JobSeeker jobSeeker, Job job) {
        saveJobs.add(jobSeeker.getName(), job);
    }

    void publish(Employer employer, Job job) throws NotSupportedJobTypeException {
        publishJobs.add(employer.getName(), job);
    }

    Jobs getPublishedJobs(String employerName) {
        return publishJobs.get(employerName);
    }

    public JobApplications getAppliedJobs(String jobSeekerName) {
        return jobSeekerJobApplications.get(jobSeekerName);
    }

    public List<String> findApplicants(String jobName) {
        return jobSeekerJobApplications.findApplicants(jobName);
    }

    public List<String> findApplicants(String jobName, LocalDate from) {
        return jobSeekerJobApplications.findApplicants(jobName, from);
    }

    public List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        return jobSeekerJobApplications.findApplicants(jobName, from, to);
    }

    public String export(ExportType type, LocalDate date) {
        return new Exporter().export(type, jobSeekerJobApplications.findApplicants(date));
    }

    public int getSuccessfulApplications(String employerName, String jobName) {
        return jobSeekerJobApplications.getSuccessfulApplications(employerName, jobName);
    }

    public int getUnsuccessfulApplications(String employerName, String jobName) {
        return jobSeekerJobApplications.getUnsuccessfulApplications(employerName, jobName);
    }
}
