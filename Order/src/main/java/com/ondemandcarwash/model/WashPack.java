package com.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="washpackage")
public class WashPack 
{
	@Id
	int id;
	String wpName;
	int wpCost;
	String wpDes;
	
	public WashPack() 
	{
		
	}

	public WashPack(int id, String wpName, int wpCost, String wpDes) {
		super();
		this.id = id;
		this.wpName = wpName;
		this.wpCost = wpCost;
		this.wpDes = wpDes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWpName() {
		return wpName;
	}

	public void setWpName(String wpName) {
		this.wpName = wpName;
	}

	public int getWpCost() {
		return wpCost;
	}

	public void setWpCost(int wpCost) {
		this.wpCost = wpCost;
	}

	public String getWpDes() {
		return wpDes;
	}

	public void setWpDes(String wpDes) {
		this.wpDes = wpDes;
	}

	@Override
	public String toString() {
		return "WashPack [id=" + id + ", wpName=" + wpName + ", wpCost=" + wpCost + ", wpDes=" + wpDes + "]";
	}
	
	
	
	
	
}
