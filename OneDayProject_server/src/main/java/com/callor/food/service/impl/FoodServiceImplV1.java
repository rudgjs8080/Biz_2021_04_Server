package com.callor.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.food.model.FoodDTO;
import com.callor.food.persistence.DBContract;
import com.callor.food.service.FoodService;

public class FoodServiceImplV1 implements FoodService {

	protected Connection dbConn;

	public FoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}

	protected List<FoodDTO> select(PreparedStatement pStr) throws SQLException {
		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		ResultSet rSet = pStr.executeQuery();
		while (rSet.next()) {
			FoodDTO foodDTO = new FoodDTO();
			foodDTO.setF_name(rSet.getString("식품명"));
			foodDTO.setF_code(rSet.getString("식품코드"));
			foodDTO.setF_year(rSet.getString("출시연도"));
			foodDTO.setC_name(rSet.getString("제조사명"));
			foodDTO.setI_name(rSet.getString("분류명"));
			foodDTO.setF_one(rSet.getInt("제공량"));
			foodDTO.setF_total(rSet.getInt("총내용량"));
			foodDTO.setF_energy(rSet.getInt("에너지"));
			foodDTO.setF_protein(rSet.getInt("단백질"));
			foodDTO.setF_fat(rSet.getInt("지방"));
			foodDTO.setF_carbon(rSet.getInt("탄수화물"));
			foodDTO.setF_sugar(rSet.getInt("총당류"));
			foodList.add(foodDTO);

		}
		rSet.close();
		return foodList;
	}

	@Override
	public List<FoodDTO> selectAll() {
		// TODO 전체조회

		String sql = " SELECT * FROM view_식품정보 ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodDTO> foodList = this.select(pStr);
			pStr.close();
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FoodDTO> findByFoodName(String name) {
		// TODO 이름으로 검색
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE ";
		sql += "식품명";
		sql += " LIKE '%' || ? || '%' ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name); // ?
			List<FoodDTO> foodList = this.select(pStr);
			pStr.close();
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
