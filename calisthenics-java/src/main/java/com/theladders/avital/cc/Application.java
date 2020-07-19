package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.theladders.avital.cc.exception.InvalidResumeException;
import com.theladders.avital.cc.exception.NotSupportedJobTypeException;
import com.theladders.avital.cc.exception.RequiresResumeForJReqJobException;
import com.theladders.avital.cc.export.ExportType;
import com.theladders.avital.cc.export.Exporter;

import static java.util.Map.Entry;

/**
 * @author sunjing
 */
public final class Application {

    private final PublishJobs publishJobs = new PublishJobs();

    private final SaveJobs saveJobs = new SaveJobs();

    private final JobApplications jobApplications = new JobApplications();

    void apply(Employer employer, Job job, JobSeeker jobSeeker, LocalDate applicationTime)
            throws RequiresResumeForJReqJobException, InvalidResumeException {
        jobApplications.addJobApplication(jobSeeker, job, employer.getName(), applicationTime);
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

    public List<JobApplication> getAppliedJobs(String jobSeekerName) {
        return jobApplications.get(jobSeekerName);
    }

    public List<String> findApplicants(String jobName) {
        return jobApplications.findApplicants(jobName);
    }

    public List<String> findApplicants(String jobName, LocalDate from) {
        return jobApplications.findApplicants(jobName, from);
    }

    public List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        return jobApplications.findApplicants(jobName, from, to);
    }

    public String export(ExportType type, LocalDate date) {
        Exporter exporter = new Exporter();
        return exporter.export(type, this.jobApplications.findApplicants(date));
    }

    public int getSuccessfulApplications(String employerName, String jobName) {
        int result = 0;
        for (Entry<String, List<JobApplication>> set : this.jobApplications.getNameToJobApplications().entrySet()) {
            List<JobApplication> jobs = set.getValue();

            result += jobs.stream().anyMatch(job -> job.getEmployerName().equals(employerName) && job.getJob().getJobName().equals(jobName)) ? 1 : 0;
        }
        return result;
    }

    public int getUnsuccessfulApplications(String employerName, String jobName) {
        return jobApplications.getUnsuccessfulApplications(employerName, jobName);
    }
}
