package com.ondemandcarwash.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ondemandcarwash.model.Order;
import com.ondemandcarwash.model.WashPack;
import com.ondemandcarwash.repository.OrderRepository;
import com.ondemandcarwash.repository.WashPackRepository;
import com.ondemandcarwash.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private WashPackRepository washPackRepository;
	
	
	
	@GetMapping("/msg")
	public String message() 
	{
		return "Hello! WELCOME from Order page";
	} 
	
	
	// Creating/Adding Order
	@PostMapping("/addorder")
	public String saveOrder(@RequestBody Order order) 
	{
		orderService.addOrder(order);
		return "Order is Placed with Washer and will be Proceesed soon " + order;
	}

	
	// Reading all Orders
	@GetMapping("/allorders")
	public List<Order> getOrder() 
	{
		return orderRepository.findAll();
	}
	
	// Reading Order by id
	@GetMapping("/orders/{id}")
	public Optional<Order> getCustomerById(@PathVariable int id) 
	{
		return orderRepository.findById(id);

	}
	
	// Deleting order by Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteOrder(@PathVariable int id)
	{
		orderService.deleteById(id);
		return new ResponseEntity<Object>("Order deleted with id" + id, HttpStatus.OK);
	}

	
	//-----------------------------------------------Washpack---------------------------------------//
	
	//Creating and adding washpack
	@PostMapping("/addpack")
	public String savePack(@RequestBody WashPack washpack)
	{
		washPackRepository.save(washpack);
		return " Pack saved successfully with id :"+washpack.getId();
	}
		
		
	//Reading all washpack
	@GetMapping("/allpacks")
	public List<WashPack> getAllPack()
	{
		return washPackRepository.findAll();
	}
		
	//Deleting washpack by id	
	@DeleteMapping("/deletepack/{id}")
	public String deletePack(@PathVariable int id)
	{
		washPackRepository.deleteById(id);
		return "pack deleted with id "+id;
	}
		
		
}

