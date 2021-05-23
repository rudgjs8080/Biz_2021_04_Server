package com.callor.student.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.student.config.MySQLConnection;
import com.callor.student.model.StudentVO;
import com.callor.student.service.StudentService;

public class StudentServiceImplV1 implements StudentService{
	protected Connection dbConn;
	
	public StudentServiceImplV1() {
		dbConn = MySQLConnection.getDBConnection();
	}
	
	protected List<StudentVO> select(PreparedStatement pStr) throws SQLException {
		List<StudentVO> stList = new ArrayList<StudentVO>();
		
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			StudentVO stVO = new StudentVO();

			stVO.setSt_seq(rSet.getLong("st_seq"));
			stVO.setSt_num(rSet.getString("st_num"));
			stVO.setSt_name(rSet.getString("st_name"));
			stVO.setSt_tel(rSet.getString("st_tel"));
			stVO.setSt_addr(rSet.getString("st_addr"));
			stVO.setSt_grade(rSet.getString("st_grade"));
			stVO.setDp_code(rSet.getString("dp_code"));
			stVO.setDp_name(rSet.getString("dp_name"));
			stVO.setDp_pro(rSet.getString("dp_pro"));
			stVO.setDp_tel(rSet.getString("dp_tel"));
			stVO.setSc_kor(rSet.getInt("sc_kor"));
			stVO.setSc_eng(rSet.getInt("sc_eng"));
			stVO.setSc_math(rSet.getInt("sc_math"));
			stVO.setSc_music(rSet.getInt("sc_music"));
			stVO.setSc_art(rSet.getInt("sc_art"));
			stVO.setSc_sw(rSet.getInt("sc_sw"));
			stVO.setSc_db(rSet.getInt("sc_db"));
			stList.add(stVO);
		
		}
		return stList;
	}
	public List<StudentVO> selectStDb(){
		String sql = "select * from view_학생정보";
		
		return null;
	}
	@Override
	public List<StudentVO> selectAll() {
		// TODO 전체조회
		
		String sql = " select * from view_성적일람표";
		sql += "order by 학번";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<StudentVO> stList = this.select(pStr);
			pStr.close();
			
			return stList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public StudentVO findById(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentVO> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer Insert(StudentVO stVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(StudentVO stVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
