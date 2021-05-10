package com.callor.food.service;

import java.util.List;

import com.callor.food.model.FoodDTO;

public interface FoodService {
	
	public List<FoodDTO> selectAll();
	
	public List<FoodDTO> findByFoodName(String name);
	
	
	
}
