package com.example.company.service;

import com.example.company.entity.Project;
import com.example.company.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Magda on 05.06.2018.
 */
@Service
public class ProjectService {


    @Autowired
    private ProjectRepository projectRepository;



    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
//
//    public Project getProject(Long projectId) {
//        return projectRepository.getOne(projectId);
//    }

    public Project getProject(Long projectId) {
        return projectRepository.findOneById(projectId);
    }

    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

//    public List getAllEmployees(Long projectId) {
//        return projectRepository.findListById(projectId);
//
//    }


}
