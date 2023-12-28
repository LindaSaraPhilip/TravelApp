package com.springboot.travelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.travelapp.model.Travel;

@Repository
public interface TravelRepo extends JpaRepository<Travel, Long>{

}
