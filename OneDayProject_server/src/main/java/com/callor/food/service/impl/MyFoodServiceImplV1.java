package com.callor.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.food.model.MyFoodDTO;
import com.callor.food.model.MyFoodVO;
import com.callor.food.persistence.DBContract;
import com.callor.food.service.MyFoodService;

public class MyFoodServiceImplV1 implements MyFoodService{
	
	protected Connection dbConn;
	
	public MyFoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
		
	}
	
	protected List<MyFoodDTO> select(PreparedStatement pStr) throws SQLException{
		List<MyFoodDTO> myFoodList = new ArrayList<MyFoodDTO>();
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			MyFoodDTO myFoodDTO = new MyFoodDTO();
			myFoodDTO.setMf_date(rSet.getString("날짜"));
			myFoodDTO.setMf_fname(rSet.getString("식품명"));
			myFoodDTO.setMf_value(rSet.getInt("섭취량"));
			myFoodDTO.setMf_one(rSet.getInt("1회제공량"));
			myFoodDTO.setMf_total(rSet.getInt("총내용량"));
			myFoodDTO.setMf_energy(rSet.getInt("에너지"));
			myFoodDTO.setMf_protein(rSet.getInt("단백질"));
			myFoodDTO.setMf_fat(rSet.getInt("지방"));
			myFoodDTO.setMf_carbon(rSet.getInt("탄수화물"));
			myFoodDTO.setMf_sugar(rSet.getInt("총당류"));
			
			myFoodList.add(myFoodDTO);
		}
		
		return myFoodList;
	}
	@Override
	public List<MyFoodDTO> selectAll() {
		// TODO 전체리스트
		
		String sql = " SELECT * FROM view_일일섭취량";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyFoodDTO> myFoodList = this.select(pStr);
			
			pStr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MyFoodDTO> findByFoodName(String name) {
		// TODO 식품명으로 조회
		
		String sql = " SELECT * FROM view_일일섭취량 ";
		sql += " WHERE 식품명 = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insert(MyFoodVO myfoodVO) {
		// 주소입력시 주의하자
		
		String sql = " INSERT INTO tbl_myfoods ";
		sql += " (mf_seq, mf_date, mf_fcode, mf_value)";
		sql += " values(seq_score.nextval, ?, ?, ?)";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, myfoodVO.getMf_date());
			pStr.setString(2, myfoodVO.getMf_fcode());
			pStr.setInt(3, myfoodVO.getMf_value());
			int result = pStr.executeUpdate();
			pStr.close();
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(MyFoodVO myfoodVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
