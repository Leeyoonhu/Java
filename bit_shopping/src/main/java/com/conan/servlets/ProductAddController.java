package com.conan.servlets;

import java.io.IOException;
import com.conan.vo.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;
/**
 * Servlet implementation class ProductAddController
 */
@WebServlet("/products/addProductProc.do")
public class ProductAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		addProductDo(request, response);
	}
	
	public void addProductDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String proId = request.getParameter("proId");
		String proName = request.getParameter("proName");
		int unitPrice = Integer.parseInt(request.getParameter("unitPrice"));
		String description = request.getParameter("description");
		String manufacturer = request.getParameter("manufacturer");
		String category = request.getParameter("category");
		int noOfStock = Integer.parseInt(request.getParameter("noOfStock"));
		
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
		String sql = null;
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			sql = "insert into products values (?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, proId);
			pstmt.setString(2, proName);
			pstmt.setInt(3, unitPrice);
			pstmt.setString(4, description);
			pstmt.setString(5, manufacturer);
			pstmt.setString(6, category);
			pstmt.setInt(7, noOfStock);
			pstmt.execute();
			RequestDispatcher rd = request.getRequestDispatcher("./productList.do");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
