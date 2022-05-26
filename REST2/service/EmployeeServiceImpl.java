package service;

import domain.Employees;
import domain.EmployeesDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService{
    private final Log logger = LogFactory.getLog(CakesServiceImpl.class);
    private final EmployeeRepository employeeRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<EmployeesDTO>  getEmployeesOlderThan(Integer age){
        return employeeRepository.getEmployeesOlderThan(age).
                stream().collect(Collectors.toList());
    };

    @Override
    void putEmployees(Integer age, Employees emp){
        employeeRepository.putEmployees(age, emp);
    };

    @Override
    void deleteEmployees(Integer age, Employees emp){
        employeeRepository.deleteEmployees(age, emp);
    };

    @Override
    List<List<Employees>> getEmployeesByAgeGroup(){
        return employeeRepository.getEmployeesByAgeGroup().stream().collect(Collectors.toList());
    };

}
