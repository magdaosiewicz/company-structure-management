//package com.example.company.rest;
//
//import com.example.company.DAO.DepartmentRepository;
//import com.example.company.DAO.EmployeeDAO;
//import com.example.company.entity.Department;
//import com.example.company.entity.Employee;
//import com.example.company.entity.Localization;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
///**
// * Created by Magda on 24.05.2018.
// */
//@RunWith(MockitoJUnitRunner.class)
//public class EmployeeControllerTest {
//
//    @InjectMocks
//    EmployeeController employeeController;
//
//    @Mock
//    DepartmentRepository departmentRepository;
//
//    @Autowired
//    EmployeeDAO employeeDAO;
//
//    @Test
//    public void addEmployee() throws Exception {
////        Department department=new Department("HR", new Localization("wawa", "Warszawa"));
////        Employee employee= new Employee(department,"magda", "osiewicz","magdalenaosiewicz@wp.pl");
////
////        when(departmentRepository.findByLocalizationIdAndName((long) 1, "wawa")).thenReturn(department);
////        Employee employee1= employeeController.addEmployee();
////
////        assertEquals(employee.getDepartment().getName(), );
//    }
//
//    @Test
//    public void getAllEmployeesByDepartment() throws Exception {
//
//    }
//
//}