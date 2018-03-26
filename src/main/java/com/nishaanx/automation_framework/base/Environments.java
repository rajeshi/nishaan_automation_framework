package com.nishaanx.automation_framework.base;

public enum Environments {
    BETA("https://beta.zipgo.in/sign_in"),
    PROD("https://beta.zipgo.in/sign_in");

    private final String url;

    private Environments(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
