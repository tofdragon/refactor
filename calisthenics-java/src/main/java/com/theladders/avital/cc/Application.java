package com.theladders.avital.cc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return publishJobs.jobsBy(employerName);
    }

    public List<JobApplication> getAppliedJobs(String jobSeekerName) {
        return jobApplications.get(jobSeekerName);
    }

    public List<String> findApplicants(String jobName) {
        return findApplicants(jobName, null);
    }

    public List<String> findApplicants(String jobName, LocalDate from) {
        return findApplicants(jobName, from, null);
    }

    public List<String> findApplicants(String jobName, LocalDate from, LocalDate to) {
        if (from == null && to == null) {
            return findApplicantsWhenFromAndToIsNull(jobName);
        }

        if (jobName == null && to == null) {
            return findApplicantsWhenJobNameAndToIsNull(from);
        }

        if (jobName == null && from == null) {
            return findApplicantsWhenJobNameAndFromIsNull(to);
        }

        if (jobName == null) {
            return findApplicantsWhenJobNameIsNull(from, to);
        }

        if (to != null) {
            return findApplicantsWhenToIsNotNull(jobName, to);
        }

        return findApplicantsOthers(jobName, from);
    }

    private List<String> findApplicantsOthers(String jobName, LocalDate from) {
        List<String> result = new ArrayList<String>() {
        };
        for (Entry<String, List<JobApplication>> set : this.jobApplications.getNameToJobApplications().entrySet()) {
            String applicant = set.getKey();
            List<JobApplication> jobs = set.getValue();
            boolean isAppliedThisDate = jobs.stream().anyMatch(job -> job.getJob().getJobName().equals(jobName)
                    && !from.isAfter(job.getApplicationTime()));
            if (isAppliedThisDate) {
                result.add(applicant);
            }
        }
        return result;
    }

    private List<String> findApplicantsWhenToIsNotNull(String jobName, LocalDate to) {
        List<String> result = new ArrayList<String>() {
        };
        for (Entry<String, List<JobApplication>> set : this.jobApplications.getNameToJobApplications().entrySet()) {
            String applicant = set.getKey();
            List<JobApplication> jobs = set.getValue();
            boolean isAppliedThisDate = jobs.stream().anyMatch(job -> job.getJob().getJobName().equals(jobName)
                    && !to.isBefore(job.getApplicationTime()));
            if (isAppliedThisDate) {
                result.add(applicant);
            }
        }
        return result;
    }

    private List<String> findApplicantsWhenJobNameIsNull(LocalDate from, LocalDate to) {
        List<String> result = new ArrayList<String>() {
        };
        for (Entry<String, List<JobApplication>> set : this.jobApplications.getNameToJobApplications().entrySet()) {
            String applicant = set.getKey();
            List<JobApplication> jobs = set.getValue();
            boolean isAppliedThisDate = jobs.stream().anyMatch(job ->
                    !from.isAfter(job.getApplicationTime()) && !to.isBefore(job.getApplicationTime()));
            if (isAppliedThisDate) {
                result.add(applicant);
            }
        }
        return result;
    }

    private List<String> findApplicantsWhenJobNameAndFromIsNull(LocalDate to) {
        List<String> result = new ArrayList<String>() {
        };
        for (Entry<String, List<JobApplication>> set : this.jobApplications.getNameToJobApplications().entrySet()) {
            String applicant = set.getKey();
            List<JobApplication> jobs = set.getValue();
            boolean isAppliedThisDate = jobs.stream().anyMatch(job ->
                    !to.isBefore(job.getApplicationTime()));
            if (isAppliedThisDate) {
                result.add(applicant);
            }
        }
        return result;
    }

    private List<String> findApplicantsWhenJobNameAndToIsNull(LocalDate from) {
        List<String> result = new ArrayList<String>() {
        };
        for (Entry<String, List<JobApplication>> set : this.jobApplications.getNameToJobApplications().entrySet()) {
            String applicant = set.getKey();
            List<JobApplication> jobs = set.getValue();
            boolean isAppliedThisDate = jobs.stream().anyMatch(job ->
                    !from.isAfter(job.getApplicationTime()));
            if (isAppliedThisDate) {
                result.add(applicant);
            }
        }
        return result;
    }

    private List<String> findApplicantsWhenFromAndToIsNull(String jobName) {
        List<String> result = new ArrayList<String>() {
        };
        for (Entry<String, List<JobApplication>> set : this.jobApplications.getNameToJobApplications().entrySet()) {
            String applicant = set.getKey();
            List<JobApplication> jobs = set.getValue();
            boolean hasAppliedToThisJob = jobs.stream().anyMatch(job -> job.getJob().getJobName().equals(jobName));
            if (hasAppliedToThisJob) {
                result.add(applicant);
            }
        }
        return result;
    }

    public String export(String type, LocalDate date) {
        if (type.equals("csv")) {
            return exportCsv(date);
        }
        return exportHtml(date);
    }

    private String exportHtml(LocalDate date) {
        String content = "";
        for (Entry<String, List<JobApplication>> set : this.jobApplications.getNameToJobApplications().entrySet()) {
            String applicant = set.getKey();
            List<JobApplication> jobs1 = set.getValue();
            List<JobApplication> appliedOnDate = jobs1.stream().filter(job ->
                    job.getApplicationTime().isEqual(date)).collect(Collectors.toList());

            for (JobApplication job : appliedOnDate) {
                content = content.concat("<tr>" + "<td>" + job.getEmployerName() + "</td>" + "<td>" + job.getJob().getJobName()
                        + "</td>" + "<td>" + job.getJob().getJobType().getType() + "</td>" + "<td>" + applicant + "</td>"
                        + "<td>" + job.getApplicationTime() + "</td>" + "</tr>");
            }
        }

        return "<!DOCTYPE html>"
                + "<body>"
                + "<table>"
                + "<thead>"
                + "<tr>"
                + "<th>Employer</th>"
                + "<th>Job</th>"
                + "<th>Job Type</th>"
                + "<th>Applicants</th>"
                + "<th>Date</th>"
                + "</tr>"
                + "</thead>"
                + "<tbody>"
                + content
                + "</tbody>"
                + "</table>"
                + "</body>"
                + "</html>";
    }

    private String exportCsv(LocalDate date) {
        String result = "Employer,Job,Job Type,Applicants,Date" + "\n";
        for (Entry<String, List<JobApplication>> set : this.jobApplications.getNameToJobApplications().entrySet()) {
            String applicant = set.getKey();
            List<JobApplication> jobs1 = set.getValue();
            List<JobApplication> appliedOnDate = jobs1.stream().filter(job ->
                    job.getApplicationTime().isEqual(date)).collect(Collectors.toList());

            for (JobApplication job : appliedOnDate) {
                result = result.concat(job.getEmployerName() + "," + job.getJob().getJobName() + ","
                        + job.getJob().getJobType().getType() + "," + applicant + "," + job.getApplicationTime() + "\n");
            }
        }
        return result;
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
