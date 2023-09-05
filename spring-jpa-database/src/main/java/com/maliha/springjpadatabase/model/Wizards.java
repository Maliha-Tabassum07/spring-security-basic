package com.maliha.springjpadatabase.model;

import jakarta.persistence.*;

@Entity
public class Wizards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Wizards() {
    }

    public Wizards(Integer id, String name, Integer house_id) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
