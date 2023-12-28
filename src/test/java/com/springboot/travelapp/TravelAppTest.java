package com.springboot.travelapp;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.springboot.travelapp.model.Travel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import com.springboot.travelapp.repository.TravelRepo;
import com.springboot.travelapp.service.TravelService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TravelAppTest {

	@Autowired
	TravelService service;
	
	@MockBean
	TravelRepo repo;
	
    @Test
   void getTravelsTestcase1() {
       
       when(repo.findAll()).thenReturn(
    		    Stream.of(
    		        new Travel(101L, "abc", "abc@gmail.com", 8123254673L, "Kochi", "Port City", 5000),
    		        new Travel(102L, "pqr", "pqr@gmail.com", 8123984073L, "Trivandrum", "Capital, Kerala", 3000)
    		    ).collect(Collectors.toList())
    		);
       assertEquals(2,service.getTravels().size());

    }
    @Test
    void getTravelsTestcase2() {
    	
List<Travel> expected = (List<Travel>)Stream.of(
    			new Travel(1001L, "abcd", "abcd@gmail.com", 8123259873L, "Japan", "Rising Sun", 50000),
  		        new Travel(1002L, "pqrs", "pqrs@gmail.com", 8187084073L, "Egypt", "Pyramids", 10000)
    			).collect(Collectors.toList());
when(repo.findAll()).thenReturn(expected);
    			

List<Travel> actual = service.getTravels();

assertEquals(expected,actual);
    	
    }
    
    @Test
    void getTravelsTestcase3()
    {
    	List<Travel> expected=Stream.of(
    			new Travel(1001L, "abcde", "abcde@gmail.com", 8103259870L, "Japan", "Rising Sun", 12300),
    			new Travel(1002L, "pqrst", "pqrst@gmail.com", 7893259870L, "Africa", "Continent", 1400300)
    			).collect(Collectors.toList());
    	when(repo.findAll()).thenReturn(expected);
    	List<Travel> actual=service.getTravels();
    	assertTimeout(Duration.ofMillis(100),()->service.getTravels());
    }
    
    @Test
    void deleteUserTestcase()
    {
    	Travel travel =new Travel(10001L, "abcdef", "abcdef@gmail.com", 9103283270L, "China", "The Great Wall", 870000);
    	service.deleteTravel(travel.getTravelid());
    	verify(repo,times(1)).deleteById(travel.getTravelid());
    }
    
    @Test
    void saveUserTestcase01()
    {
    	Travel travel=new Travel(10001L, "dummy", "dummy@gmail.com", 9108783270L, "Malayasia", "Amazing Place", 700000);
    	
    	when(repo.save(travel)).thenReturn(travel);
    	assertEquals(travel,service.addaTravel(travel));
    }

    @Test
    void saveUserTestcase02()
    {
    	Travel travel=new Travel(10001L, "dummy", "dummy@gmail.com", 9108783270L, "Malayasia", "Amazing Place", 700000);
    	
    	when(repo.save(travel)).thenReturn(travel);
    	assertTimeout(Duration.ofMillis(3),()->service.addaTravel(travel));
    	
    }
    @Test
    void saveallUserTestcase()
    {
    	
    	List<Travel> travellist = Stream.of(new Travel(100001L, "dummy01", "dummy01@gmail.com", 9987783270L, "Idukki", "Amazing Place", 9000),new Travel(100002L, "dummy02", "dummy02@gmail.com", 9675783270L, "Bangalore", "Wonderful Place", 10000)).collect(Collectors.toList());
    	when(repo.saveAll(travellist)).thenReturn(travellist);
    	assertEquals(travellist,service.addTravels(travellist));
    }
    @Test
    void updateTestcase()
    {
    	Travel updatetravel=new Travel(121L, "dummy03", "dummy03@gmail.com", 9176483270L, "Jaipur", "Amazing Place", 450000);
    	when(repo.save(updatetravel)).thenReturn(updatetravel);
    	assertEquals(updatetravel,service.updateTravel(updatetravel));
    }
}



