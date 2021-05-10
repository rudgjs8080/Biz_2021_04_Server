package com.callor.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.MyFoodDTO;
import com.callor.food.service.FoodService;
import com.callor.food.service.MyFoodService;
import com.callor.food.service.impl.FoodServiceImplV1;
import com.callor.food.service.impl.MyFoodServiceImplV1;
@WebServlet("/")
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 2486075485629848361L;

	protected FoodService fService;
	protected MyFoodService mfService;
	
	public HomeController() {
		fService = new FoodServiceImplV1();
		mfService = new MyFoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MyFoodDTO> myFoodList = mfService.selectAll();
		
		req.setAttribute("myFoodList", myFoodList);
		
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);

	}
	
	
	
	
	
}
