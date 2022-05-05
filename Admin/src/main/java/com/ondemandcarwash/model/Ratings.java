package com.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Ratings")
public class Ratings 
{
	@Id
	private int washerId;
	private String status;
	private int rating;
	private String review;
	
	
	public Ratings() 
	{
		
	}

	

	public Ratings(int washerId, String status, int rating, String review) {
		super();
		this.washerId = washerId;
		this.status = status;
		this.rating = rating;
		this.review = review;
	}



	public int getWasherId() {
		return washerId;
	}


	public void setWasherId(int washerId) {
		this.washerId = washerId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}



	@Override
	public String toString() {
		return "Ratings [washerId=" + washerId + ", status=" + status + ", rating=" + rating + ", review=" + review
				+ "]";
	}


	

	
	
	
}
