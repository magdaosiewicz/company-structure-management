package com.example.company.DTO;

import com.example.company.entity.Department;
import com.example.company.entity.Employee;
import com.example.company.entity.Project;
import lombok.*;

/**
 * Created by Magda on 06.06.2018.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;
    private String name;
    private String surname;
    private String emai;
    private DepartmentDTO department;


    public static EmployeeDTO ofEmployee(Employee employee) {

        return EmployeeDTO.builder()

                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .emai(employee.getEmai())
                .department(DepartmentDTO.ofDepartment(employee.getDepartment()))
                .build();
    }


}
