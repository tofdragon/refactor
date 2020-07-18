package com.theladders.avital.cc;

/**
 * @author sunjing
 */
enum JobType {

    JREQ("JReq"),

    ATS("ATS");

    private String type;

    JobType(String type) {
        this.type = type;
    }

    String getType() {
        return type;
    }

    static boolean isJReq(String type) {
        if (type == null || type.equals("")) {
            return false;
        }
        return type.equals(JREQ.getType());
    }

    static boolean isAts(String type) {
        if (type == null || type.equals("")) {
            return false;
        }
        return type.equals(ATS.getType());
    }
}
