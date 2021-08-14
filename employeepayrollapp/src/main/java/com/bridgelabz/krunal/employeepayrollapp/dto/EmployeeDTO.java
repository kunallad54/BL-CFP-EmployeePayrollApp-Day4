package com.bridgelabz.krunal.employeepayrollapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    @NotEmpty(message = "Please Enter the Name")
    @Pattern(regexp = "^[A-Z][a-z]{2,}$",message = "Employee name is Invalid")
    private String empName;

    @Size(max = 10, min = 10, message = "Please enter valid phone number")
    private String empMobileNo;

    @Email(message = "Please Enter the Valid Email")
    private String empEmail;

    @NotEmpty(message = "Please Enter the Address")
    private String empAddress;

    @NotNull(message = "Please Enter the salary")
    private double empSalary;

}
