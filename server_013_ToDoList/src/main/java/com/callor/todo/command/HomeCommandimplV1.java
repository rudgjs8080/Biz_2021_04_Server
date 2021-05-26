package com.callor.todo.command;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeCommandimplV1 implements TodoCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

}
