package com.example.company.DAO;

import com.example.company.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Magda on 20.05.2018.
 */
@Repository
public class DepartmentDAO extends AbstractDAO {

    public DepartmentDAO() {
        setClass(Department.class);
    }


    public Department getDepartmentById(Long id) {
        return (Department) entityManager.createQuery("SElECT d FROM Department d WHERE d.id=:departmentId")
                .setParameter("departmentId", id)
                .getSingleResult();
    }

    public Department getDepartmentByName(String name) {
        return (Department) entityManager.createQuery("SElECT d FROM Department d WHERE d.name=:departmentName")
                .setParameter("departmentName", name)
                .getSingleResult();
    }

    public List getDepartmentsByLocalization(Long localizationId) {
        return  entityManager.createQuery("SElECT department FROM Department department JOIN department.localization localization WHERE localization.id=:localizationId ")
                .setParameter("localizationId", localizationId)
                .getResultList();
    }


    public Department getDepartmentByLocalizationAndName(Long localizationId, String name) {
        return entityManager.createQuery("SELECT department FROM Department department JOIN department.localization localization WHERE localization.id=:localizationId AND department.name=:nameDepartment", Department.class)
                .setParameter("localizationId", localizationId)
                .setParameter("nameDepartment", name)
                .getSingleResult();
    }

}
