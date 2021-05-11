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
import com.callor.food.model.MyFoodDTO;
import com.callor.food.model.MyFoodVO;
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

			List<MyFoodDTO> mfList = mfService.selectAll();

			for (MyFoodDTO MF : mfList) {
				System.out.println(MF.toString());
			}
			req.setAttribute("MyFood", mfList);

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
				System.out.println("=".repeat(30));// 데이터가 잘 나오는지 확인

				req.setAttribute("MF", foodList);

				RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/search.jsp");
				disp.forward(req, resp);
			}

		} else if (subPath.equals("/insert/search2")) {

			String mf_fname = req.getParameter("mf_fname");

			List<FoodDTO> foodList = fService.findByFoodName(mf_fname);
			// List형일 경우 forEach문을 이용해서 변수값을 만든 후 사용해야 한다

			req.setAttribute("FOOD", foodList);

			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/search2.jsp");
			disp.forward(req, resp);// 중단

		} else if (subPath.equals("/insert/search3")) {
			String mf_date = req.getParameter("mf_date");
			String c_code = req.getParameter("c_code");
			Integer mf_value = Integer.valueOf(req.getParameter("mf_value"));

			MyFoodVO mfVO = new MyFoodVO();
			mfVO.setMf_date(mf_date);
			mfVO.setMf_fcode(c_code);
			mfVO.setMf_value(mf_value);// 중단

			int result = mfService.insert(mfVO);
			if (result > 0) {
				System.out.println("추가 성공");
			} else {
				System.out.println("추가 실패");
			}
			resp.sendRedirect("/food/");
			
			

		} else if (subPath.equals("/dateselect")) {
			String mf_date = req.getParameter("mf_date");

			List<MyFoodDTO> mfList = mfService.findByDate(mf_date);

			req.setAttribute("FoodDate", mfList);
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/dateselect.jsp");
			disp.forward(req, resp);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
	}

}
