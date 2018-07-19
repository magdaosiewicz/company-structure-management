package com.example.company.DTO;

import com.example.company.entity.Employee;
import com.example.company.entity.Project;
import lombok.*;

import java.util.Date;
import java.util.List;

import static java.util.Optional.ofNullable;

/**
 * Created by Magda on 06.06.2018.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDTO {

    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String projectcol;
    private List<Employee> employeeList;

    public static ProjectDTO ofProject(Project project) {
        return ProjectDTO.builder()

                .id(project.getId())
                .name(project.getName())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .projectcol(project.getProjectcol())
                .employeeList(project.getEmployeeList())
                .build();
    }






}
