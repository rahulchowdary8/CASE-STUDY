package com.ondemandcarwash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ondemandcarwash.model.Ratings;
import com.ondemandcarwash.repository.RatingRepository;

@Service
public class RatingService
{

	@Autowired
	private RatingRepository ratingRepository;
	
	
	
	//For Adding Rating
	public Ratings addRating(Ratings ratings) 
	{
		return ratingRepository.save(ratings);
		
	}

	
	//For Reading all Rating
	public List<Ratings> getAllRating()
	{
		List<Ratings> ratings = ratingRepository.findAll();
		System.out.println("Getting ratings from DB" + ratings);
		return ratings;
	}

	
	//For deleting rating by Id
	public void deleteRatingById(int id) 
	{
		ratingRepository.deleteById(id);
		
	}
}
