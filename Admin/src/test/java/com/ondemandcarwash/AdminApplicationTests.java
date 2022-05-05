package com.ondemandcarwash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ondemandcarwash.model.Admin;
import com.ondemandcarwash.repository.AdminRepository;
import com.ondemandcarwash.service.AdminService;

@SpringBootTest
class AdminApplicationTests {
	
	@Autowired
	private AdminService service;
	
	@MockBean
	private AdminRepository repository;

	@Test
	void contextLoads() {
	}

	// testing that all admin are save
	@Test
	public void getAdminTest() 
	{
		when(repository.findAll()).thenReturn(Stream
				.of(new Admin(37, "aman","aman@gmail.com","123"),
						new Admin(38, "omi","omi@gmail.com","123"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAdmins().size());
	}
	
	
	//test All admin are save correctoly 
	@Test
	public void saveUserTest() 
	{
		Admin admin= new Admin(37, "aman","aman@gmail.com","123");
		when(repository.save(admin)).thenReturn(admin);
		assertEquals(admin, service.addAdmin(admin));
	}
	
	//test all admin deleted
	@Test
	public void deleteCustomerTest() 
	{
		Admin admin = new Admin(37, "aman","aman@gmail.com","123");	
		service.deleteAdmin(admin); 
		verify(repository, times(1)).delete(admin);
	}
	
	
}
