package com.example.company.rest;

import com.example.company.DAO.DepartmentDAO;
import com.example.company.DAO.LacalizationDAO;
import com.example.company.entity.Department;
import com.example.company.entity.Localization;
import com.example.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Magda on 20.05.2018.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {


    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private LacalizationDAO lacalizationDAO;

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addDepartment(@RequestParam(value = "name") String name, @RequestParam(value = "localization") Long localizationId) {
        //departmentDAO.create(new Department(name, lacalizationDAO.getLocalizationById(localizationId)));
        departmentService.addDepartment(new Department(name, lacalizationDAO.getLocalizationById(localizationId)));
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void removeDepartment(@RequestParam(value = "name") String name, @RequestParam(value = "localization") Long localizationId) {

        //Department department= departmentDAO.getDepartmentByLocalizationAndName(localizationId, name);
        //departmentDAO.delete(department);
        departmentService.deleteDepartment(localizationId);
    }

    @RequestMapping(value = "/departmentsAll", method = RequestMethod.GET)
    public List getAllDepartments() {
        try {
           // return departmentDAO.getDepartmentsByLocalization(localizationId);
            return departmentService.getAllDepartments();
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @RequestMapping(value = "/departmentsByLocalization", method = RequestMethod.GET)
    public List getAllDepartmentsByLocalization(@RequestParam(value = "localization") Long localizationId) {
        try {
            // return departmentDAO.getDepartmentsByLocalization(localizationId);
            return departmentService.getDepartmentsByLocalization(localizationId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
