package com.example.company.rest;

import com.example.company.DAO.DepartmentDAO;
import com.example.company.DAO.EmployeeDAO;
import com.example.company.entity.Employee;
import com.example.company.repository.DepartmentRepository;
import com.example.company.service.DepartmentService;
import com.example.company.service.EmployeeService;
import com.example.company.service.LocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Magda on 23.05.2018.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private LocalizationService localizationService;

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addEmployee(@RequestParam(value = "department") String departmentName, @RequestParam(value = "localizationId") Long localizationId,
                            @RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "email") String email) {

        employeeService.addEmployee(new Employee(departmentRepository.findByLocalizationIdAndName(localizationId, departmentName), name, surname, email));
        //employeeDAO.create(new Employee(departmentDAO.getDepartmentByLocalizationAndName(localizationId, departmentName), name, surname, email));
    }


    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
    public List getAllEmployees() {
        try {
            // return employeeDAO.getEmplyeesByDepartment(departmentId);
            // return employeeService.
            return employeeService.getAllEmployees();
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @RequestMapping(value = "/employeesByDepartment", method = RequestMethod.GET)
    public List getAllEmployeesByDepartment(@RequestParam(value = "department") Long departmentId) {
        try {
            // return employeeDAO.getEmplyeesByDepartment(departmentId);
            // return employeeService.
            return employeeService.getEmployeesByDepartmentId(departmentId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


//    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
//    public Employee updateEmployee(@RequestParam(value = "employeeId") Long employeeId, @RequestParam(value = "localizationId") Long localizationId, @RequestParam(value = "department") String departmentName, @RequestParam(value = "email") String email) {
////        Project updateProject = projectDAO.getProjectById(id);
////        updateProject.getEmployeeList().add(employeeDAO.getEmployeeById(employeeId));
////        projectDAO.create(updateProject);
//
//        Employee employee = employeeService.getEmployee(employeeId);
//        employee.setEmai(email);
//        employee.setDepartment(departmentService.getDepartmentByLocalizationIdAndName(localizationId, departmentName));
//
//        return employeeService.updateEmployee(employee);
//    }


}
