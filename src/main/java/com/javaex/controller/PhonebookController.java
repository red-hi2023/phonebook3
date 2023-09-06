package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;


@WebServlet("/PhonebookController")
public class PhonebookController extends HttpServlet {
	//필드
	private static final long serialVersionUID = 1L;
    
	//생성자 디폴트 생성자사용 - 삭제
	
	//메소드 gs 필요없음
	
	//메소드 일반
	//    get방식으로 요청이 들어왔을때 실행되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라미터 action의 값을 꺼내온다   업무구분욜
		String action =request.getParameter("action");
		
		if("list".equals(action)) {
			System.out.println("action=list");
			
			//리스트/////////////////////////////////////////////////////////////////////
			//1.dao를 통해서 전체 리스트데이터 가져오기
			PersonDao personDao = new PersonDao();
			List<PersonVo> personList = personDao.personSelect("");
			
			//System.out.println(personList);
			
			//리스트 화면(html) + data 응답을 해야된다
	        //request data를 넣어둔다
			request.setAttribute("pList", personList);
			
			//list.jsp 에게 시킨다 	(포워드)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp"); //jsp파일 위치를
			rd.forward(request, response);
			//////////////////////////////////////////////////////////////////////////////
		}else if("wform".equals(action)) {
			System.out.println("action=wform");
			//등록폼///////////////////////////////////////////////////////
			
			//writeForm.jsp 에게 시킨다 	(포워드)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp"); //jsp파일 위치를
			rd.forward(request, response);
			
		}else {
			System.out.println("나머지");
		}
		
	}

	//  post방식으로 요청이 들어왔을때 실행되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
