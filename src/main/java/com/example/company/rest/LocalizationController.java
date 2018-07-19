package com.example.company.rest;

import com.example.company.DAO.LacalizationDAO;
import com.example.company.entity.Localization;
import com.example.company.service.LocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Magda on 20.05.2018.
 */

@RestController
@RequestMapping("/localizations")
public class LocalizationController {

    @Autowired
    private LacalizationDAO lacalizationDAO;

    @Autowired
    private LocalizationService localizationService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addLocalization(@RequestParam(value = "name") String name, @RequestParam(value = "address") String address) throws NoResultException {

        localizationService.addLocalization(new Localization(name, address));
            //lacalizationDAO.create(new Localization(name, address));
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeLocalization(@PathVariable(value = "id") Long id) {
        try {

         localizationService.deleteLocalization(id);
            //Localization localization = lacalizationDAO.getLocalizationById(id);
            //lacalizationDAO.delete(localization);
        } catch (NoResultException e) {

        }
    }

    @RequestMapping(value = "/localizationAll", method = RequestMethod.GET)
    public List getAllLocalizations() {
        try {
            //return lacalizationDAO.findAll();
           return localizationService.getAllLocalization();
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}
