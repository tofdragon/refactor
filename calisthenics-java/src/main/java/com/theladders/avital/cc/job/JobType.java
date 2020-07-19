package com.theladders.avital.cc.job;

/**
 * @author sunjing
 */
public enum JobType {

    JREQ("JReq"),

    ATS("ATS"),

    RJEQ("RJeq");

    private String type;

    JobType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
