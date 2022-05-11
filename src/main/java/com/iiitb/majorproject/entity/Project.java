package com.iiitb.majorproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;
    private String uid;
    private String name;

    private String ta;

    private Boolean approved=null;

    private String description;

    private String projectLink;

    public Project(Long pid, String uid, String name, String ta, Boolean approved, String description, String projectLink) {
        this.pid = pid;
        this.uid = uid;
        this.name = name;
        this.ta = ta;
        this.approved = approved;
        this.description = description;
        this.projectLink = projectLink;
    }

    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", ta='" + ta + '\'' +
                ", approved=" + approved +
                ", description='" + description + '\'' +
                ", projectLink='" + projectLink + '\'' +
                '}';
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
}
