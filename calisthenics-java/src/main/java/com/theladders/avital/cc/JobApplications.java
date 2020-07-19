package com.theladders.avital.cc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author sunjing
 */
public final class JobApplications {

    private List<JobApplication> jobApplications;

    public JobApplications() {
        jobApplications = new LinkedList<>();
    }

    void add(JobApplication jobApplication) {
        this.jobApplications.add(jobApplication);
    }

    public boolean equalsTo(JobApplications that) {
        return Objects.equals(jobApplications, that.jobApplications);
    }

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    JobApplications findApplicantsBy(Predicate<JobApplication> predicate) {
        List<JobApplication> foundJobApplications =
                getJobApplications().stream().filter(predicate).collect(Collectors.toList());

        JobApplications jobApplications = new JobApplications();
        jobApplications.getJobApplications().addAll(foundJobApplications);
        return jobApplications;
    }

    List<String> findApplicantsOfJobSeekerNameBy(Predicate<JobApplication> predicate) {
        return getJobApplications().stream().filter(predicate).map(jobApplication -> jobApplication.getJobSeekerName())
                .collect(Collectors.toList());
    }

    int countFindApplicantsBy(Predicate<JobApplication> predicate) {
       return (int)getJobApplications().stream().filter(predicate).count();
    }
}
