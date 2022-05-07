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
    private Long uid;
    private String name;

    private Long ta;

    private Boolean approved;

    public Project(Long pid, Long uid, String name, Long ta, Boolean approved) {
        this.pid = pid;
        this.uid = uid;
        this.name = name;
        this.ta = ta;
        this.approved = approved;
    }


    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", ta=" + ta +
                ", approved=" + approved +
                '}';
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTa() {
        return ta;
    }

    public void setTa(Long ta) {
        this.ta = ta;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}
