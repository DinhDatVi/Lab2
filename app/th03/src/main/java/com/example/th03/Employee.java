package com.example.th03;

public abstract class Employee {
    String id;
    String name;
    double Luong;

    public Employee(){}

    public Employee(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract protected double TinhLuong();

    @Override
    public String toString() {
        return "Mã nhân viên: " + id +
                " -- Tên nhân viên: " + name;
    }

}
