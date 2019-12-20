package com.redhat.freelance4j.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    private String projectId;

    private String ownerFirstName;

    private String ownerLastName;

    private String ownerEmailAddress;

    private String projectTitle;

    private String projectDescription;

    private String projectStatus;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(final String projectId) {
        this.projectId = projectId;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(final String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(final String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerEmailAddress() {
        return ownerEmailAddress;
    }

    public void setOwnerEmailAddress(final String ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(final String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(final String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(final String projectStatus) {
        this.projectStatus = projectStatus;
    }

}