package com.example.company.service;

import com.example.company.entity.Department;
import com.example.company.entity.Localization;
import com.example.company.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Magda on 05.06.2018.
 */
@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    public Department getDepartmentByLocalizationIdAndName(Long localizationId, String name) {
        return departmentRepository.findByLocalizationIdAndName(localizationId, name);
    }


    public Department addDepartment (Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId) {
            departmentRepository.deleteById(departmentId);
    }

    public List getAllDepartments(){
        return departmentRepository.findAll();
    }


    public List getDepartmentsByLocalization(Long localizationId) {
        return departmentRepository.findByLocalizationId(localizationId);
    }
}
