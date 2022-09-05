package org.ai.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThirdServlet
 */

// 서블릿 초기화 Parameter ==> 서블릿 파일에 직접 기술해야 하고, import another package 필요

@WebServlet(urlPatterns = {"/initP"}, 
initParams = {@WebInitParam(name="userId", value = "aaaa"), @WebInitParam(name = "userPwd", value = "9999")})
// @WebServlet(url패턴 = {"패턴이름"} , initParams = {@WebInitParam(n-v)...})
// 지정한 initParams 는 지정된 URL안에서만 사용가능
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThirdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		콘솔에서만 확인하는 건 sysout
		System.out.println("기본형은 get방식 doGet()");
//		설정한 init Parameter 가져올것임
		String userId = getInitParameter("userId"); 
		String userPwd = getInitParameter("userPwd");
//		응답의 컨텐트 타입을 html텍스트 utf8로 지정
		response.setContentType("text/html; charset=utf-8");
//		html에서도 잘 나오나 보고싶어서 PrintWriter 사용 및, 깨진 글자 나오게하기 싫어서 지정한 utf8 형식 가져옴
		PrintWriter out = response.getWriter();
//		html 파일 형식 직접 작성
		out.println("<html><head></head><body>");
		out.println("아이디 : " + userId + "<br>");
		out.println("비밀번호 : " + userPwd + "<br>");
//		다 쓴 Printer는 닫아주자
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
