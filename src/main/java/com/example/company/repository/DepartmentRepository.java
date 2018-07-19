package com.example.company.repository;

import com.example.company.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Magda on 23.05.2018.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByLocalizationIdAndName(Long localizationId, String name);

    List findByLocalizationId(Long localizationId);
}
