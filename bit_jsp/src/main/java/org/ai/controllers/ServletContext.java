package org.ai.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContext
 */
// getServletContext() 메서드를 사용해 web.xml에 접근하고
// getServletContext().getIninParameter("")를 사용해 해당 파라미터의 값을 가져옴
// 해당 예제에선 web.xml에 있는 userId와 userPwd 파라미터의 값을 가져올것 (context-param)안에 작성되어있음
@WebServlet("/ServletContext")
public class ServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("기본값 method='get'에 의해 doGet() 호출");
//		web.xml에 있는 userId와 userPwd 파라미터의 값을 가져올것 (context-param)안에 작성된 내역
		String userId = getServletContext().getInitParameter("userId");
		String userPwd = getServletContext().getInitParameter("userPwd");
//		html 에 출력할 것이므로 글자 안깨지게 형식 지정
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("아이디 : " + userId + "<br>");
		out.println("비밀번호 : " + userPwd + "<br>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
