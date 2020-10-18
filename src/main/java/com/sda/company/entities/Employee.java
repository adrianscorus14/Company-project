package com.sda.company.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Department department;
    //De creat Cascade cu filtru pentru proiect ramas fara angajat

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects = new ArrayList<>();

    @Column
    private Integer currentMonth;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Address> addressList = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime timeOfCreation;

    @CreatedBy
    private String createdBy;


    public LocalDateTime getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(LocalDateTime timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Integer getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(Integer currentMonth) {
        this.currentMonth = currentMonth;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
