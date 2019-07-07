package com.example.company.rest;

import com.example.company.entity.Localization;
import com.example.company.repository.LocalizationRepository;
import com.example.company.service.LocalizationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocalizationServiceTest {

    @InjectMocks
    LocalizationService localizationService;

    @Mock
    LocalizationRepository localizationRepository;


    @Test
    public void shouldReturnLocalization(){
        Localization localization = Localization.builder()
                .name("lolo")
                .address("Krak")
                .build();

        when(localizationRepository.save(localization)).thenReturn(localization);

        Localization addedLocalization = localizationService.addLocalization(localization);
        assertEquals(localization.getAddress(), addedLocalization.getAddress());
        assertEquals(localization.getName(), addedLocalization.getName());
        assertEquals(localization, addedLocalization);
    }


    @Test
    public void deleteLocalization(){
        Localization localization = Localization.builder()
                .name("lolo")
                .address("Krak")
                .build();
//        when(localizationRepository.save(localization)).thenReturn(localization);

        Long size = localizationRepository.count();
        localizationService.deleteLocalization(localization.getId());

        assertEquals(size-1, localizationRepository.count(), 1);
    }













}
