package com.example.company.repository;

import com.example.company.entity.Department;
import com.example.company.entity.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Magda on 05.06.2018.
 */
@Repository
public interface LocalizationRepository  extends JpaRepository<Localization, Long> {
}
