package com.example.demo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;  // Product ID, auto-incremented
    private String pname;  // Product name
    private double pcost; 
    // Product cost
    @Temporal(TemporalType.DATE)
    private Date porderdt;  // Product order date

    // Getters and Setters

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPcost() {
        return pcost;
    }

    public void setPcost(double pcost) {
        this.pcost = pcost;
    }

    public Date getPorderdt() {
        return porderdt;
    }

    public void setPorderdt(Date porderdt) {
        this.porderdt = porderdt;
    }
}
