package com.ondemandcarwash;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ondemandcarwash.model.Customer;
import com.ondemandcarwash.repository.CustomerRepository;
import com.ondemandcarwash.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerApplicationTests 
{
	
	@Autowired
	private CustomerService service;

	@MockBean
	private CustomerRepository repository;

	@Test
	public void getCustomersTest()
	{
		
		when(repository.findAll()).thenReturn(Stream
				.of(new Customer(22, "xyz","546477","xyz1@gamil","Kalyan","xyz123"),
						new Customer(12, "Nikhil","986543","nikhil@gamil","Thane","nikhil123"),
						new Customer(15, "Hemanth","56743","hemanth12@gamil","Goa","hemanth123"))
				.collect(Collectors.toList()));
		assertEquals(3, service.getCustomers().size());
	}

	@Test
	public void saveCustomerTest()
	{
		Customer customer = new Customer(22, "xyz","546477","xyz1@gamil","Kalyan","xyz123");
		when(repository.save(customer)).thenReturn(customer);
		assertEquals(customer, service.addCustomer(customer));
	}

	@Test
	public void deleteCustomerTest() 
	{
		Customer customer = new Customer(22, "xyz","546477","xyz1@gamil","Kalyan","xyz123");
		service.deleteCustomer(customer);
		verify(repository, times(1)).delete(customer);
	}

}
