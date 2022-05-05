package com.ondemandcarwash.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ondemandcarwash.model.Washer;
import com.ondemandcarwash.repository.WasherRepository;
import com.ondemandcarwash.service.WasherService;

@RestController
@RequestMapping("/washer")
public class WasherController 
{
	
	@Autowired
	private WasherService washerService;
	
	@Autowired
	private WasherRepository washerRepository;
	
	
	
	
	@GetMapping("/msg")
	public String message() {
		return "Hello! Welcome form Washer page";
	}
	
	//Creating/Adding Washer
	//http://localhost:8082/washer/addwasher
	@PostMapping("/addwasher")
	public Washer saveWasher(@RequestBody Washer washer) 
	{
		return washerService.addWasher(washer);
	}
	
	
	
	//Reading all washer
	//http://localhost:8082/washer/allwashers
	@GetMapping("/allwashers")
	public List<Washer> findAllWashers()
	{
		return washerService.getWashers();
	}

	
	//Reading Washer by ID
	//http://localhost:8082/washer/allwashers/9
	@GetMapping("/allwashers/{id}")
	public Optional<Washer> getWasherById(@PathVariable int id)
	{
		return washerRepository.findById(id);
				
	}
	
	
	//Updating Washer Data by Id
	//http://localhost:8082/washer/update/9
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateWasher(@PathVariable int id, @RequestBody Washer washer)
	{
		
			washerRepository.save(washer);
			return new ResponseEntity<Object>("Washer updated successfully with id " +id, HttpStatus.OK);
		
				
	}
	
	
	// Deleting Washer Data by Id 
	//http://localhost:8082/washer/delete/9
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteWasher(@PathVariable int id)
	{
		washerService.deleteById(id);
		return new ResponseEntity<Object>("Washer deleted with id"+id,HttpStatus.OK);
	}	
}
