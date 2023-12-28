package com.springboot.travelapp.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.springboot.travelapp.model.Travel;

@Service
public interface TravelService {
	
	public Travel addaTravel(Travel travel);
	public List<Travel> addTravels(List<Travel> travels);
	public Travel getaTravel(Long id);
	public List<Travel> getTravels();
	public Travel updateTravel(Travel travel);
	public String deleteTravel(Long id);

}

