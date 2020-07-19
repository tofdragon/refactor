package com.theladders.avital.cc.export;

import java.util.List;

import com.theladders.avital.cc.JobApplication;
import com.theladders.avital.cc.JobApplications;

/**
 * @author sunjing
 */
public final class Exporter {

    public String export(ExportType type, JobApplications jobApplications) {
        if (ExportType.CSV == type) {
            return exportCsv(jobApplications);
        }

        if (ExportType.HTML == type) {
            return exportHtml(jobApplications);
        }

        return null;
    }

    private String exportHtml(JobApplications jobApplications) {
        String content = "";

        for (JobApplication job : jobApplications.getJobApplications()) {
            content = content.concat("<tr>" + "<td>" + job.getEmployerName() + "</td>" + "<td>" + job.getJob().getJobName()
                    + "</td>" + "<td>" + job.getJob().getJobType().getType() + "</td>" + "<td>" + job.getJobSeekerName() + "</td>"
                    + "<td>" + job.getApplicationTime() + "</td>" + "</tr>");
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

    private String exportCsv(JobApplications jobApplications) {
        String result = "Employer,Job,Job Type,Applicants,Date" + "\n";
        for (JobApplication job : jobApplications.getJobApplications()) {
            result = result.concat(job.getEmployerName() + "," + job.getJob().getJobName() + ","
                    + job.getJob().getJobType().getType() + "," + job.getJobSeekerName() + "," + job.getApplicationTime() + "\n");
        }
        return result;
    }
}
