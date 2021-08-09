package com.bridgelabz.krunal.employeepayrollapp.service;

import com.bridgelabz.krunal.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.krunal.employeepayrollapp.entity.Employee;
import com.bridgelabz.krunal.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Purpose : To get all the employee details from DB and show it on console
     *
     * @return list of employee details
     */
    public List<EmployeeDTO> getEmployeeDetails() {
        return employeeRepository.findAll().stream().map(employee -> {
            return new EmployeeDTO(employee.getEmpId(), employee.getEmpName(), employee.getEmpAddress(),
                    employee.getEmpMobileNo(), employee.getEmpEmail(), employee.getEmpSalary());
        }).collect(Collectors.toList());
    }

    /**
     * Purpose : To add Employee Details to DB
     *
     * @param employeeDTO
     * @return
     */
    public EmployeeDTO addEmployeeDetails(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setEmpAddress(employeeDTO.getEmpAddress());
        employee.setEmpMobileNo(employeeDTO.getEmpMobileNo());
        employee.setEmpEmail(employeeDTO.getEmpEmail());
        employee.setEmpSalary(employeeDTO.getEmpSalary());
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
     * @param employee
     * @return
     */
    public Employee updateEmployeeDetails(int id, Employee employee) {
        Employee updateEmployeeDetails = findEmployeeByID(id);
        updateEmployeeDetails.setEmpName(employee.getEmpName());
        updateEmployeeDetails.setEmpAddress(employee.getEmpAddress());
        updateEmployeeDetails.setEmpMobileNo(employee.getEmpMobileNo());
        updateEmployeeDetails.setEmpEmail(employee.getEmpEmail());
        updateEmployeeDetails.setEmpSalary(employee.getEmpSalary());
        employeeRepository.save(updateEmployeeDetails);
        return employee;
    }

    /**
     * Purpose : To delete employee details by specifying its ID
     *
     * @param id
     * @return
     */
    public String deleteEmployeeDetails(int id) {
        Employee employee = findEmployeeByID(id);
        employeeRepository.delete(employee);
        return "Employee Details Deleted Successfully";
    }

    /**
     * Purpose : To check if employee details are their or not by ID
     *
     * @param id
     * @return
     */
    public Employee findEmployeeByID(int id) {
        return employeeRepository.findAll().stream()
                .filter(element -> element.getEmpId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Unable to find any employee"));
    }

}
