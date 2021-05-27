package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.callor.todo.config.DBContract;
import com.callor.todo.config.DBInfo;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV1 implements TodoService {

	protected Connection dbConn;

	public TodoServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}

	/*
	 * 객체(Entity, Relation) DataBase를 만들고 Table을 생성한 후 Insert 수행하면 실제상황의 데이터가 Table에
	 * 저장된다 INSERT 를 수행한 후 SELECT를 수행하여 조회를 할 수 있는 데이터들
	 * 
	 * 메타데이터(meta data) : 생성한 DataBase, table, sequence, view...가 어떤 구조로 만들어져 있는지에
	 * 대한 정보를 의미한다
	 * 
	 * ex) myDB 라는 DB에 몇개의 table이 있는지에 대한 정보를 알고 싶으면 myDB 의 메타데이터를 참조하면 된다
	 */
	protected List<Map<String, Object>> select(ResultSet rSet) throws SQLException {

		// ResultSet executeQuery를 통해 가져온 값을 저장

		// ResultSet 으로 메타데이터를 추출
		// 조회를 수행한 결과로 전달받은 Table(tbl_todolist)에
		// 몇개의 칼럼이 있는지 확인

		ResultSetMetaData md = rSet.getMetaData();

		int columns = md.getColumnCount();

		List<Map<String, Object>> tdList = new ArrayList<Map<String, Object>>();

		// rSet(select된 데이터)를 한 라인씩 추출하고
		while (rSet.next()) {
			// 각 데이터의 칼럼을 index를 기준으로
			// 값을 추출해보기
			Map<String, Object> tdVO = new HashMap<String, Object>();
			for (int i = 0; i < columns; i++) {
				// rSet.getString("td_sdate")
				// System.out.println(rSet.getObject(i));
				// 메타데이터의 index 위치의 칼럼 이름 가져오기
				String colName = md.getColumnName(i + 1);
				Object objData = rSet.getObject(i + 1);

				tdVO.put(colName, objData);

			}
			tdList.add(tdVO);

		}

		return tdList;
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		// TODO 전체조회
		String sql = " select * from tbl_todolist ";
		sql += " order by td_edate, td_sdate, td_stime";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rSet = pStr.executeQuery();

			List<Map<String, Object>> tdList = this.select(rSet);

			rSet.close();
			pStr.close();
			return tdList;
			/*
			 * ResultSetMetaData md = (ResultSetMetaData) rSet.getMetaData(); int count =
			 * md.getColumnCount();
			 * 
			 * System.out.println("=".repeat(80)); for(int i = 0 ; i < count; i++) {
			 * System.out.print(md.getColumnName(i+1) + "\t"); } System.out.println();
			 * System.out.println("=".repeat(80));
			 * 
			 * while(rSet.next()) { // System.out.print(rSet.getString("td_sdate") + "\t");
			 * // System.out.print(rSet.getString("td_stime") + "\t"); //
			 * System.out.print(rSet.getString("td_doit") + "\n"); for(int i = 0 ; i< 5 ;
			 * i++) { System.out.print(rSet.getString(i+1) + "\t"); } System.out.println();
			 * }
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Map<String, Object> findById(Long td_seq) {
		// TODO Auto-generated method stub
		String sql = " select * from tbl_todolist ";
		sql += " where td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, td_seq);
			ResultSet rSet = pStr.executeQuery();
			List<Map<String, Object>> tdList = this.select(rSet);
			if(tdList != null && tdList.size() > 0) {
				return tdList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Map<String, Object>> findBySdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> findByDoit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(Map<String, Object> tdVO) {
		// TODO TodoList 등록하기

		// 현재 날짜 가져오기
		Date date = new Date(System.currentTimeMillis());

		// 날짜를 문자열화 하기 위한 보조 클래스
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");

		String curDate = sd.format(date);
		String curTime = st.format(date);

		// tdVO에 2개의 칼럼을 생성하고
		// 데이터 추가
		tdVO.put(DBInfo.td_sdate, curDate);
		tdVO.put(DBInfo.td_stime, curTime);

		String sql = " insert into tbl_todolist (td_sdate, td_stime, td_doit)";
		sql += " values(?, ?, ?)";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, tdVO.get(DBInfo.td_sdate));
			pStr.setObject(2, tdVO.get(DBInfo.td_stime));
			pStr.setObject(3, tdVO.get(DBInfo.td_doit));
			Integer ret = pStr.executeUpdate();
			pStr.close();
			return ret;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Integer update(Map<String, Object> tdVO) {
		// TODO Auto-generated method stub
		String sql = " update tbl_todolist set ";
		sql += " td_sdate= ?, " ;
		sql += " td_stime= ?, " ;
		sql += " td_doit= ?, " ;
		sql += " td_edate= ?, " ;
		sql += " td_etime= ? " ;
		sql += " where td_seq = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setObject(1, tdVO.get(DBInfo.td_sdate));
			pStr.setObject(2, tdVO.get(DBInfo.td_stime));
			pStr.setObject(3, tdVO.get(DBInfo.td_doit));
			pStr.setObject(4, tdVO.get(DBInfo.td_edate));
			pStr.setObject(5, tdVO.get(DBInfo.td_etime));
			pStr.setObject(6, tdVO.get(DBInfo.td_seq));
			
			int ret = pStr.executeUpdate();
			pStr.close();
			return ret;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
		return null;
	}

	@Override
	public Integer delete(Long td_seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
