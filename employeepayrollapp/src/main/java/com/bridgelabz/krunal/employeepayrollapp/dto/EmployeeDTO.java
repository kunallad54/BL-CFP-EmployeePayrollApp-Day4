package com.bridgelabz.krunal.employeepayrollapp.dto;


import lombok.Data;

@Data
public class EmployeeDTO {

    private int empId;
    private String empName;
    private String empMobileNo;
    private String empEmail;
    private String empAddress;
    private double empSalary;

    public EmployeeDTO(int empId, String empName, String empMobileNo, String empEmail, String empAddress, double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empMobileNo = empMobileNo;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
        this.empSalary = empSalary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpMobileNo() {
        return empMobileNo;
    }

    public void setEmpMobileNo(String empMobileNo) {
        this.empMobileNo = empMobileNo;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }
}
