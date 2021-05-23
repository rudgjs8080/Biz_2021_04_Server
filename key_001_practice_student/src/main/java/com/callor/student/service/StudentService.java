package com.callor.student.service;

import java.util.List;

import com.callor.student.model.StudentVO;

public interface StudentService {

	public List<StudentVO> selectAll();

	public StudentVO findById(Long seq);
	public List<StudentVO> findByName();
	
	public Integer Insert(StudentVO stVO);
	public Integer update(StudentVO stVO);
	public Integer delete(Long seq);
}
