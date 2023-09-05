package com.maliha.springjpadatabase.repository;

import com.maliha.springjpadatabase.model.Wizards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WizardInterface extends JpaRepository<Wizards,Integer> {

}
