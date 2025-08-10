package com.oop.groupone.bgpress_group1.Sumaiya;

import java.io.Serializable;
import java.time.LocalDate;

public class User  implements Serializable {
    private String id, name, jobname, phoneNo, email, address, gender, password;
    private LocalDate dob;


    public User(String id, String name, String jobname, String phoneNo, String email, String address, String gender, String password, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.jobname = jobname;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.password = password;
        this.dob = dob;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobname='" + jobname + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                '}';
    }
}