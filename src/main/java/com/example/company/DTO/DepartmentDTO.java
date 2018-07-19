package com.example.company.DTO;

import com.example.company.entity.Department;
import com.example.company.entity.Employee;
import com.example.company.entity.Localization;
import lombok.*;

/**
 * Created by Magda on 06.06.2018.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {

    private Long id;
    private LocalizationDTO localization;
    private String name;

    public static DepartmentDTO ofDepartment(Department department) {

        return DepartmentDTO.builder()
                .id(department.getId())
                .localization(LocalizationDTO.ofLocalization(department.getLocalization()))
                .name(department.getName())
                .build();
    }

}
