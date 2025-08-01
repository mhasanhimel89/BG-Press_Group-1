package com.oop.groupone.bgpress_group1.Sumaiya.headmanager;

import com.oop.groupone.bgpress_group1.Sumaiya.User;

import java.time.LocalDate;

public class headmanager  extends User  {
    public headmanager(String id, String name, String phoneNo, String email, String address, String gender, String password, LocalDate dob, LocalDate doj) {
        super(id, name, phoneNo, email, address, gender, password, dob, doj);
    }
}
