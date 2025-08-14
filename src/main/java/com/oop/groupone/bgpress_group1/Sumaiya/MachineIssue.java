package com.oop.groupone.bgpress_group1.Sumaiya;

import java.io.Serializable;

public class MachineIssue implements Serializable {
   private String machineId,issueType,detailedProblem;

    public MachineIssue(String machineId, String issueType, String detailedProblem) {
        this.machineId = machineId;
        this.issueType = issueType;
        this.detailedProblem = detailedProblem;
    }

    public String getDetailedProblem() {
        return detailedProblem;
    }

    public void setDetailedProblem(String detailedProblem) {
        this.detailedProblem = detailedProblem;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    @Override
    public String toString() {
        return "MachineIssue{" +
                "machineId='" + machineId + '\'' +
                ", issueType='" + issueType + '\'' +
                ", detailedProblem='" + detailedProblem + '\'' +
                '}';
    }
}
