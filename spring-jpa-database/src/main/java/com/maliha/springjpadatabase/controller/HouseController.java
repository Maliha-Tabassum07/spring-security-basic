package com.maliha.springjpadatabase.controller;

import com.maliha.springjpadatabase.model.House;
import com.maliha.springjpadatabase.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/house/all")
    public ResponseEntity<List<House>> getAllHouse() {
        List<House> houseList = houseService.getAllHouse();
        return new ResponseEntity<>(houseList, HttpStatus.OK);
    }

    @GetMapping("/house/{id}")
    public ResponseEntity<House> getHouseById(@PathVariable Integer id) {
        House house = houseService.getHouseById(id).get();
        return new ResponseEntity<>(house, HttpStatus.OK);
    }

    @PostMapping("/add/house")
    public ResponseEntity<Void> addHouse(@RequestBody House house) {
        houseService.addHouses(house);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @DeleteMapping("/delete/house/{id}")
    public boolean deleteHouse(@PathVariable Integer id) throws NullPointerException{
        houseService.deleteHouseById(id);
        return true;
    }

}
