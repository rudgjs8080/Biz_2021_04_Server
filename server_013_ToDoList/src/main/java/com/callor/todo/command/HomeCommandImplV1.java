package com.callor.todo.command;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;

public class HomeCommandImplV1 implements TodoCommand {

	protected TodoService tdService;
	protected static final Logger log = LoggerFactory.getLogger("tdService");

	/*
	 * (서비스) 등의 클래스를 객체로 생성하여 클래스 내부의 여러 method에서 공용으로 사용할 경우 객체를 클래스의 멤버 영역에 선언한다
	 * 이때 객체의 접근제한자를 protected 로 하면 이 클래스를 상속받는 곳에서도 공용으로 사용할 수 있다 이러한 코드가 상당한 이점을
	 * 가지고 있지만 간혹 메모리 leak(누수)가 발생할 수 있다 이럴때는 객체를 final로 선언해 주는 것도 한 가지 방법이다 단, 객체를
	 * final로 선언할 경우는 반드시 생성자에서 초기화를 해줘야 한다
	 */
	public HomeCommandImplV1() {
		tdService = new TodoServiceImplV1();

	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> tdList = tdService.selectAll();

		log.debug("SELECT {} ", tdList.toString());

		req.setAttribute("TDLIST", tdList);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}

}
