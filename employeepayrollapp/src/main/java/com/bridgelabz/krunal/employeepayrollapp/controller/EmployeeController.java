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
import com.bridgelabz.krunal.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.krunal.employeepayrollapp.entity.Employee;
import com.bridgelabz.krunal.employeepayrollapp.service.EmployeeService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<ResponseDTO> getEmployeeDetails() {
        List<Employee> employeeDetails = employeeService.getEmployeeDetails();
        ResponseDTO responseDTO = new ResponseDTO("Got all employee details", employeeDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to use PostMapping HTTP method to add employee details to database
     *
     * @param employeeDTO
     * @return
     */
    @PostMapping(value = "/addEmployeeDetails")
    public ResponseEntity<ResponseDTO> addEmployeeDetails(@Valid @RequestBody EmployeeDTO employeeDTO,
                                                          BindingResult er) {
        if (er.hasErrors()) {
            List<String> errors = er.getAllErrors().stream().map(objectError -> {
                return objectError.getDefaultMessage();
            }).collect(Collectors.toList());

            return new ResponseEntity<>(new ResponseDTO("Validation Error", errors)
                    , HttpStatus.BAD_REQUEST);
        }
        EmployeeDTO addEmployeeDetails = employeeService.addEmployeeDetails(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added new employee details", addEmployeeDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to get employee Details by their ID using GetMapping HTTP method
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getEmployeeDetailsByID")
    public ResponseEntity<ResponseDTO> getEmployeeByID(@RequestParam(name = "id") int id) {
        Employee employeeDetailsByID = employeeService.getEmployeeDetailsByID(id);
        ResponseDTO responseDTO = new ResponseDTO("Got employee details by ID", employeeDetailsByID);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to update employee details in database using PUTMAPPING HTTP method
     *
     * @param id
     * @param employeeDTO
     * @return
     */
    @PutMapping(value = "/updateEmployeeDetails")
    public ResponseEntity<ResponseDTO> updateEmployeeDetails(@Valid @RequestParam(name = "id") int id,
                                                             @RequestBody EmployeeDTO employeeDTO,
                                                             BindingResult er) {
        if (er.hasErrors()) {
            List<String> errors = er.getAllErrors().stream().map(objectError -> {
                return objectError.getDefaultMessage();
            }).collect(Collectors.toList());

            return new ResponseEntity<>(new ResponseDTO("Validation Error", errors)
                    , HttpStatus.BAD_REQUEST);
        }
        Employee updateEmployeeDetails = employeeService.updateEmployeeDetails(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Details", updateEmployeeDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to delete employee details by their ID using deleteMapping HTTP method
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteEmployeeDetails")
    public ResponseEntity<ResponseDTO> deleteEmployeeDetails(@RequestParam(name = "id") int id) {
        Employee deleteEmployeeDetails = employeeService.deleteEmployeeDetails(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted the employee details", deleteEmployeeDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
