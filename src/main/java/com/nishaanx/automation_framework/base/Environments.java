package com.nishaanx.automation_framework.base;

public enum Environments {
    BETA("https://uat-rcgpportal.cs87.force.com/RCGP_Validation?id=a3Z8E000000Cu1MUAS&order=1&site=a0d8E000001OpIH&GMC=Y&Type=AIT"),
    PROD("https://beta.zipgo.in/sign_in");

    private final String url;

    private Environments(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
