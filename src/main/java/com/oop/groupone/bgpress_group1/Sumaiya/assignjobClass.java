package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.scene.control.Alert;

import java.security.PrivateKey;
import java.time.LocalDate;

public class assignjobClass extends User {
    private String Jobname, assignstaff , jobtype, progress;
    private LocalDate duedate;

    public assignjobClass(String jobname, String assignstaff, String jobtype,String progress, LocalDate duedate) {
        this.Jobname = jobname;
        this.assignstaff = assignstaff;
        this.jobtype = jobtype;
        this.progress=progress;
        this.duedate = duedate;
    }

    @Override
    public String toString() {
        return "assignjobClass{" +
                "Jobname='" + Jobname + '\'' +
                ", assignstaff='" + assignstaff + '\'' +
                ", jobtype='" + jobtype + '\'' +
                ", progress="+ progress + '\'' +
                ", duedate=" + duedate +
                '}';
    }

    public String getJobname() {
        return Jobname;
    }

    public void setJobname(String jobname) {
        Jobname = jobname;
    }

    public String getAssignstaff() {
        return assignstaff;
    }

    public void setAssignstaff(String assignstaff) {
        this.assignstaff = assignstaff;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public void ShowAlert(String title, String header){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(
                "Job Name=" + Jobname +'\n'+
                        "Assign Staff=" + assignstaff + '\n' +
                        "Job Type=" + jobtype +'\n'+
                        "Due Date='" + duedate + '\n'

        );
        alert.showAndWait();
    }

}
