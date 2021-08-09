/***********************************************************************************************************
 *
 * Purpose : Create a Employee Payroll Spring Project to cater to REST Request from Employee Payroll UI
 *           Create a Rest Controller to demonstrate the various HTTP Methods
 *
 * @author Krunal Lad
 * @since 09-08-2021
 *
 **********************************************************************************************************/

package com.bridgelabz.krunal.employeepayrollapp.controller;

import com.bridgelabz.krunal.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.krunal.employeepayrollapp.entity.Employee;
import com.bridgelabz.krunal.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Purpose : Ability to use GetMapping HTTP request to fetch all data from database
     *
     * @return
     */
    @GetMapping(value = "/getEmployeeDetails")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeDetails(){
        return new ResponseEntity<>(employeeService.getEmployeeDetails(), HttpStatus.OK);
    }

    /**
     * Purpose : Ability to use PostMapping HTTP method to add employee details to database
     *
     * @param employeeDTO
     * @return
     */
    @PostMapping(value = "/addEmployeeDetails")
    public ResponseEntity<EmployeeDTO> addEmployeeDetails(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.addEmployeeDetails(employeeDTO),HttpStatus.OK);
    }

    /**
     * Purpose : Ability to get employee Details by their ID using GetMapping HTTP method
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getEmployeeDetailsByID")
    public ResponseEntity<Employee> getEmployeeByID(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(employeeService.getEmployeeDetailsByID(id), HttpStatus.OK);
    }

    /**
     * Purpose : Ability to update employee details in database using PUTMAPPING HTTP method
     *
     * @param id
     * @param employee
     * @return
     */
    @PutMapping(value = "/updateEmployeeDetails")
    public ResponseEntity<Employee> updateEmployeeDetails(@RequestParam(name = "id") int id,
                                                   @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployeeDetails(id, employee), HttpStatus.OK);
    }

    /**
     * Purpose : Ability to delete employee details by their ID using deleteMapping HTTP method
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteEmployeeDetails")
    public ResponseEntity<String> deleteEmployeeDetails(@RequestParam(name = "id") int id) {
        return new ResponseEntity<>(employeeService.deleteEmployeeDetails(id), HttpStatus.OK);
    }
}
