package edu.miu.nomin.jpa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String employeementDate;
    private double yearlySalary;
    @JsonManagedReference
    private PensionPlan pensionPlan;

    public Employee() {
    }
    public Employee(long employeeId, String firstName, String lastName, String employeementDate, double yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeementDate = employeementDate;
        this.yearlySalary = yearlySalary;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }
    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmployeementDate() {
        return employeementDate;
    }
    public void setEmployeementDate(String employeementDate) {
        this.employeementDate = employeementDate;
    }
    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }
    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeementDate='" + employeementDate + '\'' +
                ", yearlySalary=" + yearlySalary +
                '}';
    }
}
