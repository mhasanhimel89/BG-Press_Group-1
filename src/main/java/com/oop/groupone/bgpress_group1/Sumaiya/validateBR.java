package com.oop.groupone.bgpress_group1.Sumaiya;

import java.io.Serializable;

public class validateBR implements Serializable {
    private String resourcename;
    private int quantity;
    private double budget;

    public validateBR(String resourcename, int quantity, double budget) {
        this.resourcename = resourcename;
        this.quantity = quantity;
        this.budget = budget;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "validateBR{" +
                "resourcename='" + resourcename + '\'' +
                ", quantity=" + quantity +
                ", budget=" + budget +
                '}';
    }
}
