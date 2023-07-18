package com.chakri.microservices.webservices.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;


public class UserEntity {
    @Size(min = 2)
    private String name;

    private int id;

    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public long getSalary() {
        return salary;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    private long salary;

    @Past
    private Date dateOfBirth;

    public UserEntity(String name, int id, String department, long salary, Date dateOfBirth) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }
}
