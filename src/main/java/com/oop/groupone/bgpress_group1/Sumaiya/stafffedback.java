package com.oop.groupone.bgpress_group1.Sumaiya;

import java.io.Serializable;
import java.time.LocalDate;

public class stafffedback  implements Serializable {
    String staffname, staffid, feedback;
    LocalDate date;

    public stafffedback(String staffname, String staffid, String feedback, LocalDate date) {
        this.staffname = staffname;
        this.staffid = staffid;
        this.feedback = feedback;
        this.date = date;
    }



    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "stafffedback{" +
                "staffname='" + staffname + '\'' +
                ", staffid='" + staffid + '\'' +
                ", feedback='" + feedback + '\'' +
                ", date=" + date +
                '}';
    }
}
