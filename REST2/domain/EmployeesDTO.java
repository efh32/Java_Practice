package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesDTO {
    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
    private String profile_image;

    public EmployeesDTO(Employees employee){

        this.employee_name = employee.getEmployee_name();
        this.employee_age = employee.getEmployee_age();
        this.employee_salary = employee.getEmployee_salary();
        this.profile_image = employee.getProfile_image();
    }

}
