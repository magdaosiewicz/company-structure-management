package com.example.company.DAO;

import com.example.company.entity.Localization;
import org.springframework.stereotype.Repository;

/**
 * Created by Magda on 20.05.2018.
 */
@Repository
public class LacalizationDAO extends AbstractDAO {


    public LacalizationDAO() {
        setClass(Localization.class);
    }

    public Localization getLocalizationById(Long id) {
        return (Localization) entityManager.createQuery("SElECT l FROM Localization l WHERE l.id=:localizationId")
                .setParameter("localizationId", id)
                .getSingleResult();
    }

    public Localization getLocalizationByNameAndAddress(String name, String address) {
        return (Localization) entityManager.createQuery("SElECT l FROM Localization l WHERE l.name=:name and l.address=:address")
                .setParameter("name", name)
                .setParameter("address", address)

                .getSingleResult();
    }

    public Localization getLocalizationByDepartment(Long id) {
        return (Localization) entityManager.createQuery("SElECT l FROM Localization l WHERE l.id=:localizationId")
                .setParameter("localizationId", id)
                .getSingleResult();
    }


}
