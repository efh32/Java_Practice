package service;

import domain.Employees;
import domain.EmployeesDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {


    public List<EmployeesDTO>  getEmployeesOlderThan(Integer age);
    public void putEmployees(Integer age, Employees emp);
    public void deleteEmployees(Integer age, Employees emp);
    public List<List<Employees>> getEmployeesByAgeGroup();


}
