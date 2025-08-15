package com.oop.groupone.bgpress_group1.Sumaiya;

import java.io.Serializable;
import java.time.LocalDate;

public class generatereport implements Serializable {
    private String week,staffid,progress;

    public generatereport(String week, String staffid, String progress) {
        this.week = week;
        this.staffid = staffid;
        this.progress = progress;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "generatereport{" +
                "week='" + week + '\'' +
                ", staffid='" + staffid + '\'' +
                ", progress='" + progress + '\'' +
                '}';
    }
}
