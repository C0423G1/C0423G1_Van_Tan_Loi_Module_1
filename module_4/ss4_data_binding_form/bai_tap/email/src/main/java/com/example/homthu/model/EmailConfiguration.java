package com.example.homthu.model;

public class EmailConfiguration {
    private String language;
    private int pageSize;
    private String spamsfilter;
    private String signature;

    public EmailConfiguration(String language, int pageSize, String spamsfilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamsfilter = spamsfilter;
        this.signature = signature;
    }

    public EmailConfiguration() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamsfilter() {
        return spamsfilter;
    }

    public void setSpamsfilter(String spamsfilter) {
        this.spamsfilter = spamsfilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
