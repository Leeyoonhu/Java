package org.ai.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet1
 */

@WebServlet("/dispatcher1")
public class DispatcherServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h3>Dispatcher Test1 수행 결과</h3>");
//		출력할때 출력 버퍼에 저장했다가 forward 할때 버퍼를 비워버리기때문에 Test1 수행 결과는 출력되지 않음
//		Test1 수행 결과를 출력하고 싶으면 forward가 아닌 include를 통해 버퍼를 비우지 않고 출력버퍼에 저장한 상태로 가지고감
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/dispatcher2");
		rd.forward(request, response);
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
