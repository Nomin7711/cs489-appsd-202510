package edu.miu.nomin.jpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.beans.Transient;

public class PensionPlan {
    private String planReferenceNumber;
    private String enrollmentDate;
    private double monthlyContribution;
    @JsonBackReference
    private Employee employee;

    public PensionPlan(Employee employee,String planReferenceNumber, String enrollmentDate, double monthlyContribution) {
        this.employee = employee;
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }
    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }
    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }
    public String getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    public double getMonthlyContribution() {
        return monthlyContribution;
    }
    public void setMonthlyContribution(double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    @Override
    public String toString() {
        return "PensionPlan{" +
                "planReferenceNumber='" + planReferenceNumber + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                ", monthlyContribution=" + monthlyContribution +
                '}';
    }
}
