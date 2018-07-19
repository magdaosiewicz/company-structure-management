package com.example.company.service;

import com.example.company.entity.Employee;
import com.example.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Magda on 05.06.2018.
 */
@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;



    public Employee addEmployee (Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long employeeId){
        return employeeRepository.getOne(employeeId);
    }

    public List getAllEmployees(){
        return employeeRepository.findAll();
    }

    public List getEmployeesByDepartmentId(Long departmentId){
        return employeeRepository.findAllByDepartmentId(departmentId);
    }

//    public List getEmployeesByProjectId(Long projectId){
//        return employeeRepository.findAllByProjectId(projectId);
//    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }



}
