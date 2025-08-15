package com.oop.groupone.bgpress_group1.Sumaiya;

public class salaryslip {
    private String employeeId, name,  jobname, month, year;
    private double basicSalary;
    private double bonus;
    private double deduction;
    private double netsalary;

    public salaryslip(String employeeId, String name, String jobname, String month, String year, double basicSalary, double bonus, double deduction, double netsalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.jobname = jobname;
        this.month = month;
        this.year = year;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.deduction = deduction;
        this.netsalary = netsalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public double getNetsalary() {
        return netsalary;
    }

    public void setNetsalary(double netsalary) {
        this.netsalary = netsalary;
    }

    @Override
    public String toString() {
        return "salaryslip{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", jobname='" + jobname + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", basicSalary=" + basicSalary +
                ", bonus=" + bonus +
                ", deduction=" + deduction +
                ", netsalary=" + netsalary +
                '}';
    }
}
