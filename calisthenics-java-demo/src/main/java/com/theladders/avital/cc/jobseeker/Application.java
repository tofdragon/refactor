package com.theladders.avital.cc.jobseeker;

import java.time.LocalDate;

/**
 * @author sunjing
 */
public class Application {

    private LocalDate applicationTime;

    private String employerName;

    private Application() {
    }

    public static Application create(LocalDate applicationTime, String employerName) {
        Application application = new Application();
        application.applicationTime = applicationTime;
        application.employerName = employerName;
        return application;
    }

    public LocalDate getApplicationTime() {
        return applicationTime;
    }

    public String getEmployerName() {
        return employerName;
    }
}
