package com.maliha.springjpadatabase.repository;

import com.maliha.springjpadatabase.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInterface extends JpaRepository<House,Integer> {
}
