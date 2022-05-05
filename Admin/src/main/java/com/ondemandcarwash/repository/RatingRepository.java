package com.ondemandcarwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ondemandcarwash.model.Ratings;

public interface RatingRepository extends MongoRepository<Ratings, Integer>
{

}
