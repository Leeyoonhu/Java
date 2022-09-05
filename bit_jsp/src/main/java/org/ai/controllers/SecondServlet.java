package org.ai.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */

/* 응답 정보 처리 */ 
/* url pattern을 해석하면 / 의 root 주소는 프로젝트 내의 webapp임 */
@WebServlet(name="second", urlPatterns = {"/second"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 정보 처리 과정을 보기 위해 재작성 (form의 기본 method 값은 get방식)
		System.out.println("doGet() 메서드 호출");
		response.setContentType("text/html; charset=UTF-8");
		/* utf-8의 컨텐츠 타입 지정 */
		PrintWriter out = response.getWriter();
		/* 지정된 타입 방식으로 출력 할것임 */
		/* System.out.println(); 은 console 에만 출력되기때문에 PrintWriter로 출력한 것 */
		out.print("<h1>좋은 하루!</h1>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 정보 처리 과정을 보기 위해 재작성
		System.out.println("doPost() 메서드 호출");
		response.setContentType("text/html; charset=UTF-8");
		/* utf-8의 컨텐츠 타입 지정 */
		PrintWriter out = response.getWriter();
		/* 지정된 타입 방식으로 출력 할것임 */
		out.print("<h1>POST 방식으로 호출되었음</h1>");
		out.print("<h3>좋은 하루!</h3>");
		out.close();
	}

}
