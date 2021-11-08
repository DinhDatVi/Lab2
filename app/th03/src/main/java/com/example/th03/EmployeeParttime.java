package com.example.th03;

public class EmployeeParttime extends Employee{
    @Override
    protected double TinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' + " -- Lương thời vụ: " + '\'' + TinhLuong();
    }
}
