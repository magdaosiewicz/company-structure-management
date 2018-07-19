package com.example.company.repository;

import com.example.company.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Magda on 05.06.2018.
 */
@Repository
public interface ProjectRepository  extends JpaRepository<Project, Long> {
    //List<Employee> findListById(Long projectId);

    Project findOneById(Long projectId);
}
