package com.maliha.springjpadatabase.service;

import com.maliha.springjpadatabase.model.House;
import com.maliha.springjpadatabase.repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    @Autowired
    private RepositoryInterface repositoryInterface;

    public List<House> getAllHouse(){
        return repositoryInterface.findAll();

    }
    public Optional<House> getHouseById(Integer id){
        return repositoryInterface.findById(id);
    }

    public void addHouses(House house){
        repositoryInterface.save(house);
    }

    public void deleteHouseById(Integer id){
        repositoryInterface.deleteById(id);
    }





}
