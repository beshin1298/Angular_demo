package com.example.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position_name")
    private String positionName;

    @OneToOne(mappedBy = "position")
    Employee employee;

    public Position() {
    }

    public Position(String positionName, Employee employee) {
        this.positionName = positionName;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
