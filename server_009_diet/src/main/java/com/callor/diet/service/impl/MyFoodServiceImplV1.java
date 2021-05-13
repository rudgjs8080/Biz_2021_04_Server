package com.callor.diet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.callor.diet.config.DBContract;
import com.callor.diet.model.MyFoodCDTO;
import com.callor.diet.model.MyFoodVO;
import com.callor.diet.service.MyFoodService;

public class MyFoodServiceImplV1 implements MyFoodService{
	
	protected Connection dbConn;
	public MyFoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	
	@Override
	public List<MyFoodCDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyFoodCDTO findById(long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyFoodCDTO> findByName(String mf_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyFoodCDTO> findByDate(String mf_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(MyFoodVO myFoodVO) {
		// TODO 삽입
		String sql = " INSERT INTO tbl_myfoods( ";
				sql += "mf_seq,";
				sql += "mf_date,";
				sql += "mf_fcode,";
				sql += "mf_amt)";
				sql += " VALUES( ";
				sql += "seq_myfoods.NEXTVAL,";
				sql += "?, ";
				sql += "?, ";
				sql += "?)";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, myFoodVO.getMf_date());
			pStr.setString(2, myFoodVO.getMf_fcode());
			pStr.setFloat(3, myFoodVO.getMf_amt());
			
			Integer result = pStr.executeUpdate();
			pStr.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer update(MyFoodVO myFoodVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(long seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
