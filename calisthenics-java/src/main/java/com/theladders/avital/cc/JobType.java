package com.theladders.avital.cc;

/**
 * @author sunjing
 */
enum JobType {

    JREQ("JReq"),

    ATS("ATS"),

    RJEQ("RJeq");

    private String type;

    JobType(String type) {
        this.type = type;
    }

    String getType() {
        return type;
    }
}
