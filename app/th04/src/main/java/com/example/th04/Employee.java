package com.example.th04;

public class Employee {
    private String id;
    private String name;
    private boolean isManager;

    public Employee() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isManager() {
        return this.isManager;
    }

    public void setManager(boolean manager) {
        this.isManager = manager;
    }

    public String toString() {
        return this.id + " - " + this.name;
    }
}

