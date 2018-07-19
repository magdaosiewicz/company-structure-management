package com.example.company.repository;

import com.example.company.entity.Department;
import com.example.company.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Magda on 05.06.2018.
 */
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    List findAllByDepartmentId(Long departmentId);
   // List findAllByProjectId(Long projectId);


}
