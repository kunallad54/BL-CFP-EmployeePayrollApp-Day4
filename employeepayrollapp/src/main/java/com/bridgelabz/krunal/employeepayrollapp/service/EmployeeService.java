package com.bridgelabz.krunal.employeepayrollapp.service;

import com.bridgelabz.krunal.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.krunal.employeepayrollapp.entity.Employee;
import com.bridgelabz.krunal.employeepayrollapp.exception.EmployeePayrollExceptions;
import com.bridgelabz.krunal.employeepayrollapp.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ModelMapper mapper = new ModelMapper();

    /**
     * Purpose : To get all the employee details from DB and show it on console
     *
     * @return list of employee details
     */
    public List<Employee> getEmployeeDetails() {
        return this.employeeRepository.findAll();
    }

    /**
     * Purpose : To add Employee Details to DB
     *
     * @param employeeDTO
     * @return
     */
    public EmployeeDTO addEmployeeDetails(EmployeeDTO employeeDTO) {
        Employee employee = mapper.map(employeeDTO,Employee.class);
        employeeRepository.save(employee);
        return employeeDTO;
    }

    /**
     * Purpose : To get employee details by their ID
     *
     * @param id
     * @return
     */
    public Employee getEmployeeDetailsByID(int id) {
        Employee employee = findEmployeeByID(id);
        return employee;
    }

    /**
     * Purpose : To update employee details by verifying ID
     *
     * @param id
     * @param employeeDTO
     * @return
     */
    public Employee updateEmployeeDetails(int id, EmployeeDTO employeeDTO) {
        Employee updateEmployeeDetails = findEmployeeByID(id);
        updateEmployeeDetails.setEmpName(employeeDTO.getEmpName());
        updateEmployeeDetails.setEmpAddress(employeeDTO.getEmpAddress());
        updateEmployeeDetails.setEmpMobileNo(employeeDTO.getEmpMobileNo());
        updateEmployeeDetails.setEmpEmail(employeeDTO.getEmpEmail());
        updateEmployeeDetails.setEmpSalary(employeeDTO.getEmpSalary());
        employeeRepository.save(updateEmployeeDetails);
        return updateEmployeeDetails;
    }

    /**
     * Purpose : To delete employee details by specifying its ID
     *
     * @param id
     * @return
     */
    public Employee deleteEmployeeDetails(int id) {
        Employee employee = findEmployeeByID(id);
        employeeRepository.delete(employee);
        System.out.println("Employee Details Deleted Successfully");
        return employee;
    }

    /**
     * Purpose : To check if employee details are their or not by ID
     *
     * @param id
     * @return
     */
    public Employee findEmployeeByID(int id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeePayrollExceptions("Unable to find any employee", EmployeePayrollExceptions.ExceptionType.EMPLOYEE_NOT_FOUND));
    }

}
