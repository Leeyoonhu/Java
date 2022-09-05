package org.ai.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletResponseEx01
 */
@WebServlet("/portal")
public class HttpServletResponseEx01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpServletResponseEx01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		site의 value값을 param 변수에 담음
		String param = request.getParameter("site");
		if(param.equals("naver")) {
			response.sendRedirect("http://www.naver.com");
//			해당 directory로 갈때는 request 객체 정보가 없으므로 객체 정보를 담고싶다면 RequestDispatcher 사용
		}
		else if(param.equals("google")) {
			response.sendRedirect("http://www.google.com");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
