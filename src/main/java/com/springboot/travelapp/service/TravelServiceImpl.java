package com.springboot.travelapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot.travelapp.model.Travel;
import com.springboot.travelapp.repository.TravelRepo;

@Service
public class TravelServiceImpl implements TravelService {
	
	public static final Logger logger =LoggerFactory.getLogger(TravelServiceImpl.class);
	
	@Autowired
	TravelRepo repo;

	@Override
	public Travel addaTravel(Travel travel) {
		Travel savedTravel =null;
		try
		{
		   
		   logger.info("Travel destination {} has been added successfully", travel.getDestination());
		   savedTravel=repo.save(travel);
	    }
		catch(Exception e)
		{
			logger.error("Sorry..Something went wrong not able to add your travel"+travel.getDestination());
			
		}
		return savedTravel;
	}

	@Override
	public List<Travel> addTravels(List<Travel> travels) {
		return repo.saveAll(travels);
		
	}

	@Override
	public Travel getaTravel(Long id) {
		
		return repo.findById(id).orElse(null);
		 
	}

	@Override
	public List<Travel> getTravels() {
		
		return repo.findAll();
	}

	@Override
	public Travel updateTravel(Travel travel) {
		
		return repo.save(travel);
	}

	@Override
	public String deleteTravel(Long id) {
		
		 repo.deleteById(id);
		 return id+" is removed !";
	}

}
