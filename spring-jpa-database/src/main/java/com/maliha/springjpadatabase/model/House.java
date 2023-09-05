package com.maliha.springjpadatabase.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int house_id;
    private String name;
    private int position;
    private int score;

//    @OneToMany(cascade = CascadeType.PERSIST)
    @OneToMany
    List<Wizards> wizards;

    public House(){

    }

    public House(int house_id, String name, int position,int score) {
        this.house_id=house_id;
        this.name = name;
        this.position = position;
        this.score=score;
    }



    public int getId() {
        return house_id;
    }

    public void setId(int id) {
        this.house_id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Wizards> getWizards() {
        return wizards;
    }

    public void setWizards(List<Wizards> wizardsList) {
        this.wizards = wizardsList;
    }


}

