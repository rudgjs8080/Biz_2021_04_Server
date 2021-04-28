package com.callor.welcome.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/kumho")
public class MyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<h1>금호고 40회</h1>");
		out.println("<h1>어서옵쇼</h1>");
		out.println("<a href=http://kumho.gen.hs.kr/ </a>");
		out.println("<h1>금호고 바로가기</h1>");
		out.println("<a href=http://www.kjdaily.com/read.php3?aid=1594031845516481062 </a>");
		out.println("<h1>심장군 기사 바로가기</h1>");
		out.close();
	
	}
	
	
	
}
