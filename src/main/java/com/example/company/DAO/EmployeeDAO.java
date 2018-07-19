package com.example.company.DAO;

import com.example.company.entity.Employee;
import com.example.company.entity.Localization;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Magda on 23.05.2018.
 */
@Repository
public class EmployeeDAO extends AbstractDAO{

    public EmployeeDAO(){setClass(Employee.class);}

    public Employee getEmployeeById(Long id) {
        return (Employee) entityManager.createQuery("SElECT e FROM Employee e WHERE e.id=:employeeId")
                .setParameter("employeeId", id)
                .getSingleResult();
    }

    public List getEmplyeesByDepartment(Long departmentId) {
        return  entityManager.createQuery("SElECT employee FROM Employee employee JOIN employee.department department WHERE department.id=:departmentId ")
                .setParameter("departmentId", departmentId)
                .getResultList();
    }






}
