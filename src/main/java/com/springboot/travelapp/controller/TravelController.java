package com.springboot.travelapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.travelapp.model.Travel;
import com.springboot.travelapp.service.TravelService;

@RestController
public class TravelController {
	
	@Autowired
	private TravelService service;
	
	@PostMapping("/addTravel")
	public Travel addTravel(@RequestBody Travel travel)
	{
		return service.addaTravel(travel);
		 
	}
	
	@PostMapping("/addTravels")
	public List<Travel> addTravels(@RequestBody List<Travel> travels)
	{
		return (List<Travel>) service.addTravels(travels);
	}
	
	@GetMapping("/getTravel/{id}")
	public Travel getTravel(@PathVariable Long id)
	{
		return service.getaTravel(id);
	}
	
	@GetMapping("/getTravels")
	public List<Travel> getTravelslist()
	{
		return service.getTravels();
	}
	
	@PostMapping("/updateTravel")
	public Travel updateTravelobj(@RequestBody Travel travel)
	{
		Travel existingTravel=new Travel();
		existingTravel.setName(travel.getName());
		existingTravel.setTravelid(travel.getTravelid());
		existingTravel.setEmail(travel.getEmail());
		existingTravel.setMobile(travel.getMobile());
		existingTravel.setDescp(travel.getDescp());
		existingTravel.setDestination(travel.getDestination());
		existingTravel.setPrice(travel.getPrice());
		return service.updateTravel(existingTravel);
	}
	@DeleteMapping("/deleteTravel/{id}")
	public String RemoveTravel(@PathVariable Long id)
	{
		return service.deleteTravel(id);
	}
	
	

}
