package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
    private String profile_image;
    private Date lastModifiedDate;
    private Date createdDate;
    private boolean active;
}
