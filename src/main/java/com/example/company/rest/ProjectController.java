package com.example.company.rest;

import com.example.company.DAO.EmployeeDAO;
import com.example.company.DAO.ProjectDAO;
import com.example.company.DTO.ProjectDTO;
import com.example.company.entity.Project;
import com.example.company.service.EmployeeService;
import com.example.company.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Magda on 23.05.2018.
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addProject(@RequestParam(value = "name") String name, @RequestParam(value = "start") Date startDate, @RequestParam(value = "end") Date endDate, @RequestParam(value = "projectcol") String projectcol) {

        //  List<Employee> empleyees = new ArrayList<>();
        projectService.addProject(new Project(name, startDate, endDate, projectcol, null));
        //projectDAO.create(new Project(name, startDate, endDate, projectcol, null));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void removeProject(@RequestParam(value = "id") Long id) {
        projectService.deleteProject(id);
        //Project project = projectDAO.getProjectById(id);
        //projectDAO.delete(project);
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.PUT)
    public void addProjectEmployee(@RequestParam(value = "id") Long id, @RequestParam(value = "employeeId") Long employeeId) {
//        Project updateProject = projectDAO.getProjectById(id);
//        updateProject.getEmployeeList().add(employeeDAO.getEmployeeById(employeeId));
//        projectDAO.create(updateProject);

        Project project = projectService.getProject(id);
        project.getEmployeeList().add(employeeService.getEmployee(employeeId));
        projectService.updateProject(project);
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.PUT)
    public void removeEmployeeOfProject(@RequestParam(value = "id") Long id, @RequestParam(value = "employeeId") Long employeeId) {
        Project project = projectService.getProject(id);
        project.getEmployeeList().remove(employeeService.getEmployee(employeeId));
        projectService.updateProject(project);
    }

    @RequestMapping(value = "/employeesByProject", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployeesByProject(@RequestParam(value = "project") Long projectId) throws Exception {
        try {
            if (projectService.getProject(projectId) == null) {
                throw new Exception("Such a project doesn't exist!");
            } else if (projectService.getProject(projectId).getEmployeeList().isEmpty()) {
                throw new Exception("The are no employees in the project!");
            }
            return ResponseEntity.ok(ProjectDTO.ofProject(projectService.getProject(projectId)).getEmployeeList());
        } catch (Exception e) {
            throw new Exception("Something went wrong :(");
        }
    }


}
