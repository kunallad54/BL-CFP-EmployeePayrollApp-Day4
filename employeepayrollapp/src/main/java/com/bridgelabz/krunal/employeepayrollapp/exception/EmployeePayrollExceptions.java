package com.bridgelabz.krunal.employeepayrollapp.exception;

public class EmployeePayrollExceptions extends RuntimeException {

    private ExceptionType type;

    public enum ExceptionType{
        EMPLOYEE_NOT_FOUND;
    }

    public EmployeePayrollExceptions(String message,ExceptionType type) {
        super(message);
        this.type=type;
    }
}
