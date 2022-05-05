package com.ondemandcarwash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ondemandcarwash.model.Washer;
import com.ondemandcarwash.repository.WasherRepository;

@Service
public class WasherService 
{
	@Autowired
	private WasherRepository washerRepository;
	
  
	//for creating/adding washer
	public Washer addWasher(Washer washer)
	{
		return washerRepository.save(washer);
	}
 
	
	////For getting All Washer
	public List<Washer> getWashers() 
	{
		// TODO Auto-generated method stub
		List<Washer> washer= washerRepository.findAll();
		System.out.println("Getting Washer from DB" + washer);
		return washer;
	}

	//For deleting By Id
	public void deleteById(int id)
	{
		washerRepository.deleteById(id);
		
	}
	
	//For deleting
	public void deleteWasher(Washer washer) 
	{
		washerRepository.delete(washer);
	}
	

	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { Washer foundedWasher =
	 * washerRepository.findByEmail(username);
	 * 
	 * if (foundedWasher ==null) return null; String Email =
	 * foundedWasher.getEmail(); String Password = foundedWasher.getPassword();
	 * return new User(Email, Password, new ArrayList<>()); }
	 */
	
	
}
