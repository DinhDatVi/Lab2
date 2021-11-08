package com.example.th03;


public class EmployeeFulltime extends Employee {
    @Override
    protected double TinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString() + " -- Lương chính thức: " + TinhLuong();
    }
}
