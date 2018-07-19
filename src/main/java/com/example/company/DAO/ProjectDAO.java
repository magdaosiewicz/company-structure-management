package com.example.company.DAO;

import com.example.company.entity.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Magda on 23.05.2018.
 */
@Repository
public class ProjectDAO extends AbstractDAO {


    public ProjectDAO(){setClass(Project.class);}

    public Project getProjectById(Long id) {
        return (Project) entityManager.createQuery("SElECT p FROM Project p WHERE p.id=:projectId")
                .setParameter("projectId", id)
                .getSingleResult();
    }
    public List getEmplyees(Long projectId) {
        return  entityManager.createQuery("SElECT employee FROM Employee employee JOIN employee.project project WHERE project.id=:projectId ")
                .setParameter("projectId", projectId)
                .getResultList();
    }





}
