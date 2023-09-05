package com.maliha.springjpadatabase.controller;

import com.maliha.springjpadatabase.model.Wizards;
import com.maliha.springjpadatabase.service.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WizardController {
    @Autowired
    WizardService wizardService;

    @GetMapping("/wizard/all")
    public ResponseEntity<List<Wizards>> getAllWizard() {
        List<Wizards> wizardList = wizardService.getAllWizards();
        return new ResponseEntity<>(wizardList, HttpStatus.OK);
    }

    @GetMapping("/wizard/{id}")
    public ResponseEntity<Wizards> getWizardById(@PathVariable Integer id) {
        Wizards wizard = wizardService.getWizardById(id).get();
        return new ResponseEntity<>(wizard, HttpStatus.OK);
    }

    @PostMapping("/add/wizard/house/{id}")
    public ResponseEntity<Void> addWizard(@RequestBody Wizards wizard,@PathVariable Integer id) {
        wizardService.addWizards(wizard, id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @DeleteMapping("/delete/wizard/{Wid}/{Hid}")
    public boolean deleteWizard(@PathVariable("Wid") Integer wizardId,@PathVariable("Wid") Integer HouseId) {
        wizardService.deleteWizardById(wizardId,HouseId);
        return true;
    }
//    @DeleteMapping("/delete/wizard/{id}")
//    public boolean deleteWizard(@PathVariable Integer wizardId) {
//        wizardService.deleteWizardById(wizardId);
//        return true;
//    }
    @PutMapping("/update/wizard/{id}")
    public boolean updateWizard(@RequestBody Wizards wizard, @PathVariable Integer id) {
        wizardService.updateWizard(wizard);
        return true;
    }

}
