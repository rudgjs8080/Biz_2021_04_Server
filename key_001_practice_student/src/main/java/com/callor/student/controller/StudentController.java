package com.callor.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImplV1;

@WebServlet("/student/*")
public class StudentController extends HttpServlet{

	private static final long serialVersionUID = 5436200177970472148L;
	
	protected StudentService stService;
	public StudentController() {
	
		stService = new StudentServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subPath = req.getPathInfo();
		
	}
	
	
	
}
