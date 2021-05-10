package com.callor.food.service;

import java.util.List;

import com.callor.food.model.MyFoodDTO;
import com.callor.food.model.MyFoodVO;

public interface MyFoodService {
	
	public List<MyFoodDTO> selectAll();
	
	// 식품명으로 섭취정보 조회
	public List<MyFoodDTO> findByFoodName(String name);
	
	public int insert(MyFoodVO myfoodVO);
	public int update(MyFoodVO myfoodVO);
	public int delete(Long seq); // ?? parameter 잘 모르겠음
	
	
	
	
	
	
	
	
	
}
