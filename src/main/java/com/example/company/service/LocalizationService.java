package com.example.company.service;

import com.example.company.entity.Localization;
import com.example.company.repository.LocalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magda on 05.06.2018.
 */
@Service
public class LocalizationService {


    @Autowired
    private LocalizationRepository localizationRepository;


    public Localization addLocalization (Localization localization) {
        return localizationRepository.save(localization);
    }

    public void deleteLocalization(Long localizationId) {
        localizationRepository.deleteById(localizationId);
    }

    public List getAllLocalization(){
        return localizationRepository.findAll();
    }








}
