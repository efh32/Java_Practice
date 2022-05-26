package repository;

import domain.Employees;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {

    void putEmployees(Integer age, Employees emp);

    void deleteEmployees(Integer age, Employees emp);
    List<Employees>  getEmployeesOlderThan(Integer age);
    List<List<Employees>> getEmployeesByAgeGroup();
}
