package com.theladders.avital.cc;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.theladders.avital.cc.exception.InvalidResumeException;
import com.theladders.avital.cc.exception.NotSupportedJobTypeException;
import com.theladders.avital.cc.exception.RequiresResumeForJReqJobException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ApplicationTest {
    Application application;

    private ArrayList<String> createNewJob(String jobName, JobType jobType, String employerName, String applicationTime) {
        return new ArrayList<String>() {{
            add(jobName);
            add(jobType.getType());
            add(applicationTime);
            add(employerName);
        }};
    }

    private JobApplication createApplyJob(String employerName, Job job, String applicationTime) {
        return JobApplication.create(employerName, job, LocalDate.parse(applicationTime));
    }

    private Job createNewJob(final String jobName, final JobType jobType) {
        return Job.create(jobName, jobType);
    }


    @Before
    public void setUp() throws Exception {
        application = new Application();
    }

    @Test
    public void employers_should_be_able_to_publish_a_job() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerName = "";
        String jobName = "高级前端开发";
        application.publish(Employer.create(employerName), Job.create(jobName, JobType.JREQ));

        Jobs tempJobs = application.getPublishedJobs(employerName);
        assertTrue(tempJobs.includeJob(createNewJob("高级前端开发", JobType.JREQ)));
    }

    @Test
    public void employers_should_only_be_able_to_see_jobs_published_by_them() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String employerTencent = "Tencent";
        String seniorJavaDevJob = "高级Java开发";
        String juniorJavaDevJob = "Java开发";
        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ));
        application.publish(Employer.create(employerTencent), Job.create(juniorJavaDevJob, JobType.JREQ));

        Jobs jobs = application.getPublishedJobs(employerAlibaba);
        assertTrue(jobs.includeJob(createNewJob("高级Java开发", JobType.JREQ)));
    }

    @Test
    public void employers_should_be_able_to_publish_ATS_jobs() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String seniorJavaDevJob = "高级Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS));
        Jobs jobs = application.getPublishedJobs(employerAlibaba);
        assertTrue(jobs.includeJob(createNewJob("高级Java开发", JobType.ATS)));
    }

    @Test(expected = NotSupportedJobTypeException.class)
    public void employers_should_not_be_able_to_publish_jobs_that_are_neither_ATS_nor_JReq() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String seniorJavaDevJob = "高级Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.RJEQ));
    }

    @Test
    public void jobseekers_should_be_able_to_save_jobs_published_by_employers_for_later_review() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerName = "Jacky";
        String jobName = "高级Java开发";
        application.publish(Employer.create(employerAlibaba), Job.create(jobName, JobType.JREQ));
        application.save(JobSeeker.create(jobSeekerName), Job.create(jobName, JobType.JREQ));

        Jobs savedJobs = application.getPublishedJobs(employerAlibaba);
        assertTrue(savedJobs.includeJob(createNewJob("高级Java开发", JobType.JREQ)));
    }

    @Test
    public void jobseekers_should_be_able_to_apply_for_an_ATS_job_some_employer_published_without_a_resume() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerName = "Jacky";
        String seniorJavaDevJob = "高级Java开发";
        String juniorJavaDevJob = "Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS));
        application.publish(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS),
                JobSeeker.create(jobSeekerName), LocalDate.parse("2020-01-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS),
                JobSeeker.create(jobSeekerName), LocalDate.parse("2020-01-01"));
        List<JobApplication> appliedJobs = application.getAppliedJobs(jobSeekerName);

        List<JobApplication> expected = new ArrayList<JobApplication>() {{
            add(createApplyJob( "Alibaba", Job.create("Java开发", JobType.ATS),"2020-01-01"));
            add(createApplyJob("Alibaba", Job.create("高级Java开发", JobType.ATS), "2020-01-01"));
        }};

        assertThat(appliedJobs, is(expected));
    }

    @Test(expected = RequiresResumeForJReqJobException.class)
    public void jobseekers_should_not_be_able_to_apply_for_an_JReq_job_some_employer_published_without_a_resume() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerName = "Jacky";
        String seniorJavaDevJob = "高级Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ), JobSeeker.create(jobSeekerName), LocalDate.now());
    }

    @Test(expected = InvalidResumeException.class)
    public void jobseekers_should_not_be_able_to_apply_for_an_JReq_job_some_employer_published_with_someone_else_s_resume() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerName = "Jacky";
        String seniorJavaDevJob = "高级Java开发";
        String resumeApplicantName = "Jacky Chen";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ),
                JobSeeker.create(jobSeekerName, resumeApplicantName), LocalDate.now());
    }

    @Test
    public void employers_should_be_able_to_find_applicants_of_a_job() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerJacky = "Jacky";
        String jobSeekerLam = "Lam";
        String seniorJavaDevJob = "高级Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.now());
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerLam), LocalDate.now());
        List<String> applicants = application.findApplicants(seniorJavaDevJob);

        List<String> expected = new ArrayList<String>() {{
            add("Lam");
            add("Jacky");
        }};

        assertThat(applicants, is(expected));
    }

    @Test
    public void employers_should_be_able_to_find_applicants_to_a_job_by_application_date() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerJacky = "Jacky";
        String jobSeekerHo = "Ho";
        String seniorJavaDevJob = "高级Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.parse("1997-07-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerHo), LocalDate.parse("1999-12-20"));
        List<String> applicants = application.findApplicants(null, LocalDate.parse("1999-12-20"));

        List<String> expected = new ArrayList<String>() {{
            add("Ho");
        }};

        assertThat(applicants, is(expected));
    }

    @Test
    public void employers_should_be_able_to_find_applicants_to_a_job_by_period_when_period_end_is_given_while_period_start_is_not() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerJacky = "Jacky";
        String jobSeekerHo = "Ho";
        String seniorJavaDevJob = "高级Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.parse("1997-07-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerHo), LocalDate.parse("1999-12-20"));
        List<String> applicants = application.findApplicants(null, null, LocalDate.parse("1999-01-01"));

        List<String> expected = new ArrayList<String>() {{
            add("Jacky");
        }};

        assertThat(applicants, is(expected));
    }

    @Test
    public void employers_should_be_able_to_find_applicants_to_a_job_by_period() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerJacky = "Jacky";
        String jobSeekerHo = "Ho";
        String seniorJavaDevJob = "高级Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.parse("1997-07-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerHo), LocalDate.parse("1999-12-20"));
        List<String> applicants = application.findApplicants(null, LocalDate.parse("1997-07-01"), LocalDate.parse("1999-12-20"));

        List<String> expected = new ArrayList<String>() {{
            add("Ho");
            add("Jacky");
        }};

        assertThat(applicants, is(expected));
    }

    @Test
    public void employers_should_be_able_to_find_applicants_to_a_job_by_job_name_and_period_when_period_start_is_given_while_period_end_is_not() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerJacky = "Jacky";
        String resumeApplicantName = "Jacky";
        String jobSeekerHo = "Ho";
        String seniorJavaDevJob = "高级Java开发";
        String juniorJavaDevJob = "Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS));
        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.parse("1997-07-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ), JobSeeker.create(jobSeekerJacky, resumeApplicantName), LocalDate.parse("1999-12-20"));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerHo), LocalDate.parse("1999-12-20"));

        List<String> applicants = application.findApplicants(seniorJavaDevJob, LocalDate.parse("1999-12-20"));

        List<String> expected = new ArrayList<String>() {{
            add("Jacky");
        }};

        assertThat(applicants, is(expected));
    }

    @Test
    public void employers_should_be_able_to_find_applicants_to_a_job_by_job_name_and_period_when_period_end_is_given_while_period_start_is_not() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerJacky = "Jacky";
        String jobSeekerHo = "Ho";
        String seniorJavaDevJob = "高级Java开发";
        String juniorJavaDevJob = "Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS));
        application.publish(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.parse("1997-07-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.parse("1997-07-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerHo), LocalDate.parse("1999-12-20"));

        List<String> applicants = application.findApplicants(juniorJavaDevJob, null, LocalDate.parse("1999-01-01"));

        List<String> expected = new ArrayList<String>() {{
            add("Jacky");
        }};

        assertThat(applicants, is(expected));
    }

    @Test
    public void employers_should_be_able_to_find_applicants_to_a_job_by_job_name_and_period() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerWong = "Wong";
        String jobSeekerJacky = "Jacky";
        String jobSeekerHo = "Ho";
        String jobSeekerLam = "Lam";
        String seniorJavaDevJob = "高级Java开发";
        String juniorJavaDevJob = "Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS));
        application.publish(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS));
        application.publish(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerWong), LocalDate.parse("1997-07-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.parse("1997-07-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerHo), LocalDate.parse("1998-01-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerLam), LocalDate.parse("1999-12-20"));

        List<String> applicants = application.findApplicants(juniorJavaDevJob, LocalDate.parse("1997-01-01"), LocalDate.parse("1999-01-01"));

        List<String> expected = new ArrayList<String>() {{
            add("Ho");
            add("Jacky");
        }};

        assertThat(applicants, is(expected));
    }

    @Test
    public void should_generator_csv_reports_of_all_jobseekers_on_a_given_date() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerJacky = "Jacky";
        String jackyResume = "Jacky";
        String jobSeekerHo = "Ho";
        String jobSeekerLam = "Lam";
        String lamResume = "Lam";
        String seniorJavaDevJob = "高级Java开发";
        String juniorJavaDevJob = "Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS));
        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.parse("1997-07-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ), JobSeeker.create(jobSeekerJacky, jackyResume), LocalDate.parse("1999-12-20"));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerHo), LocalDate.parse("1999-12-20"));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerLam), LocalDate.parse("1999-12-20"));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ), JobSeeker.create(jobSeekerLam, lamResume), LocalDate.parse("1999-12-20"));

        String csv = application.export("csv", LocalDate.parse("1999-12-20"));
        String expected = "Employer,Job,Job Type,Applicants,Date" + "\n" + "Alibaba,Java开发,ATS,Ho,1999-12-20" + "\n" + "Alibaba,Java开发,ATS,Lam,1999-12-20" + "\n" + "Alibaba,高级Java开发,JReq,Lam,1999-12-20" + "\n" + "Alibaba,高级Java开发,JReq,Jacky,1999-12-20" + "\n";

        assertThat(csv, is(expected));
    }

    @Test
    public void should_generator_html_reports_of_all_jobseekers_on_a_given_date() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerJacky = "Jacky";
        String jackyResume = "Jacky";
        String jobSeekerHo = "Ho";
        String jobSeekerLam = "Lam";
        String lamResume = "Lam";
        String seniorJavaDevJob = "高级Java开发";
        String juniorJavaDevJob = "Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS));
        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.parse("1997-07-01"));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ), JobSeeker.create(jobSeekerJacky, jackyResume), LocalDate.parse("1999-12-20"));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerHo), LocalDate.parse("1999-12-20"));
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerLam), LocalDate.parse("1999-12-20"));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ), JobSeeker.create(jobSeekerLam, lamResume), LocalDate.parse("1999-12-20"));

        String csv = application.export("html", LocalDate.parse("1999-12-20"));
        String expected = "<!DOCTYPE html>"
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
                + "<tr>"
                + "<td>Alibaba</td>"
                + "<td>Java开发</td>"
                + "<td>ATS</td>"
                + "<td>Ho</td>"
                + "<td>1999-12-20</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Alibaba</td>"
                + "<td>Java开发</td>"
                + "<td>ATS</td>"
                + "<td>Lam</td>"
                + "<td>1999-12-20</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Alibaba</td>"
                + "<td>高级Java开发</td>"
                + "<td>JReq</td>"
                + "<td>Lam</td>"
                + "<td>1999-12-20</td>"
                + "</tr>"
                + "<tr>"
                + "<td>Alibaba</td>"
                + "<td>高级Java开发</td>"
                + "<td>JReq</td>"
                + "<td>Jacky</td>"
                + "<td>1999-12-20</td>"
                + "</tr>"
                + "</tbody>"
                + "</table>"
                + "</body>"
                + "</html>";

        assertThat(csv, is(expected));
    }

    @Test
    public void should_be_able_to_see_successful_application_of_a_job_for_an_employer() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String employerTencent = "Tencent";
        String jobSeekerJacky = "Jacky";
        String jobSeekerHo = "Ho";
        String jobSeekerLam = "Lam";
        String seniorJavaDevJob = "高级Java开发";
        String juniorJavaDevJob = "Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS));
        application.publish(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS));
        application.publish(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS));
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerJacky), LocalDate.now());
        application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerLam), LocalDate.now());
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerHo), LocalDate.now());
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerHo), LocalDate.now());

        assertThat(application.getSuccessfulApplications(employerAlibaba, seniorJavaDevJob), is(2));
        assertThat(application.getSuccessfulApplications(employerAlibaba, juniorJavaDevJob), is(1));
    }

    @Test
    public void should_be_able_to_see_unsuccessful_applications_of_a_job_for_an_employer() throws NotSupportedJobTypeException, RequiresResumeForJReqJobException, InvalidResumeException {
        String employerAlibaba = "Alibaba";
        String jobSeekerJacky = "Jacky";
        String jobSeekerLam = "Lam";
        String seniorJavaDevJob = "高级Java开发";
        String juniorJavaDevJob = "Java开发";

        application.publish(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ));
        application.publish(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS));
        try {
            application.apply(Employer.create(employerAlibaba), Job.create(seniorJavaDevJob, JobType.JREQ), JobSeeker.create(jobSeekerJacky), LocalDate.now());
        } catch (RequiresResumeForJReqJobException ignored) {}
        application.apply(Employer.create(employerAlibaba), Job.create(juniorJavaDevJob, JobType.ATS), JobSeeker.create(jobSeekerLam), LocalDate.now());

        assertThat(application.getUnsuccessfulApplications(employerAlibaba, seniorJavaDevJob), is(1));
        assertThat(application.getUnsuccessfulApplications(employerAlibaba, juniorJavaDevJob), is(0));
    }
}
