package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc")
public class phonebookController extends HttpServlet {
	//필드
	private static final long serialVersionUID = 1L;
       
    //생성자 -기본 생성자 사용
    public phonebookController() {
    
    }

    //메소드 -gs
    
    //메소드 -일반
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("phonebookController.goGet()");
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		if("wform".equals(action)) {
			System.out.println("wform:등록폼");
			
			RequestDispatcher rd=request.getRequestDispatcher("/writeform.jsp");
		    rd.forward(request, response);
		} else if("insert".equals(action)) {
			System.out.println("insert:등록");
			
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			//vo로 묶기
			PersonVo personVo = new PersonVo(name, hp, company);
			System.out.println(personVo.toString());
			
			//db 관련 업무
			PhoneDao phoneDao = new PhoneDao();
			
			//db에 저장
			phoneDao.personInsert(personVo);
			
			//리다이랙트
			response.sendRedirect("http://localhost:8080/phonebook3/pbc?action=list");
			
			/*
			//db에서 전체 데이터 가져오기
			List<PersonVo> personList = phoneDao.personSelect();
			
			//request에 담기
			request.setAttribute("personList", personList);
			
			//포워드
			RequestDispatcher rd=request.getRequestDispatcher("/list.jsp");
		    rd.forward(request, response);
			*/
		} else if("list".equals(action)) {
			System.out.println("list: 리스트");
			
			//db 사용
			PhoneDao phoneDao = new PhoneDao();
			
			// 리스트 가져오기
			List<PersonVo> personList = phoneDao.personSelect();
			System.out.println(personList);
			
			//데이터 담기 포워드
			request.setAttribute("personList", personList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
			
		} else if("delete".equals(action)) {
			System.out.println("delete:삭제");
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			
			//db 사용
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personDelete(no);
			
			//리다이랙트
			response.sendRedirect("http://localhost:8080/phonebook3/pbc?action=list");
			
		} else if("eform".equals(action)) {
			System.out.println("eform:수정폼");
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			
			RequestDispatcher rd=request.getRequestDispatcher("/editform.jsp");
		    rd.forward(request, response);
		} else if("edit".equals(action)) {
			System.out.println("edit:수정");
			
			//파라미터 가져와서 출력해보기
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			String name = request.getParameter("name"); 
			String hp = request.getParameter("hp");
		    String company = request.getParameter("company");
		    System.out.println(name);
		    System.out.println(hp);
		    System.out.println(company);
		    
		    
		    //db 사용
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personEdit(no, name, hp, company);
			
			
			//리다이랙트
			response.sendRedirect("http://localhost:8080/phonebook3/pbc?action=list");
		    
		}
	   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
