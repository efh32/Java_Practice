package controller;


import domain.Employees;
import domain.EmployeesDTO;

import org.springframework.web.bind.annotation.*;
import service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employeesOlder/{age}")
    public ResponseEntity<List<EmployeesDTO>>  getEmployeesOlderThan(@PathVariable Integer age){
        return new ResponseEntity<>(employeeService.getEmployeesOlderThan(age), HttpStatus.OK);
    }

    @GetMapping("/employeesByAge")
    public ResponseEntity<List<List<EmployeesDTO>>> getEmployeesByAgeGroup(){
        return new ResponseEntity<>(employeeService.getEmployeesByAgeGroup(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> putEmployees(@PathVariable Integer age, @PathVariable Employees emp){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> deleteEmployees(@PathVariable Integer age, @PathVariable Employees emp){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/exception")
    public ResponseEntity<EmployeesDTO> testException() throws Exception{
        throw new Exception("..");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("this is 404 response", HttpStatus.NOT_FOUND);
    }

}
