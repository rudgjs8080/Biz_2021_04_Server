package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.FoodDTO;
import com.callor.food.service.FoodService;
import com.callor.food.service.MyFoodService;
import com.callor.food.service.impl.FoodServiceImplV1;
import com.callor.food.service.impl.MyFoodServiceImplV1;

@WebServlet("/food/*")
public class FoodController extends HttpServlet {

	private static final long serialVersionUID = 7528534125211741994L;

	protected FoodService fService;
	protected MyFoodService mfService;

	public FoodController() {

		fService = new FoodServiceImplV1();
		mfService = new MyFoodServiceImplV1();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subPath = req.getPathInfo();

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		if (subPath.equals("/insert")) {
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/insert.jsp");
			disp.forward(req, resp);

		} else if (subPath.equals("/insert/search")) {
			String mf_fname = req.getParameter("mf_fname");
			if (mf_fname == null || mf_fname.equals("")) {
				out.println("식품명을 반드시 입력해주세요");
				out.close();
			} else {

				List<FoodDTO> foodList = fService.findByFoodName(mf_fname);

				System.out.println("=".repeat(30));
				for (FoodDTO f : foodList) {
					System.out.println(f.toString());
				}
				System.out.println("=".repeat(30));

				req.setAttribute("MF", foodList);
				
				RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/search.jsp");
				disp.forward(req, resp);
			}

		}else if(subPath.equals("/insert/search2")) {
			
			String mf_fname = req.getParameter("mf_fname");
			
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/search2.jsp");
			disp.forward(req, resp);
			
			
		}

	}

}
