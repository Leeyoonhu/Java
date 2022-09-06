package com.conan.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.oreilly.servlet.multipart.*;
import com.oreilly.servlet.*;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.*;
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
		String proId = null;
		String proName = null;
		int unitPrice = 0;
		String description = null;
		String manufacturer = null;
		String category = null;
		int noOfStock = 0;
		String fileName = null;
		
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
		String sql = null;
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ServletContext application = getServletContext();
		String path = application.getRealPath("/upload");
		int size = 1024 * 1024 * 10;
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			proId = multi.getParameter("proId");
			proName = multi.getParameter("proName");
			unitPrice = Integer.parseInt(multi.getParameter("unitPrice"));
			description = multi.getParameter("description");
			manufacturer = multi.getParameter("manufacturer");
			category = multi.getParameter("category");
			noOfStock = Integer.parseInt(multi.getParameter("noOfStock"));
			fileName = multi.getOriginalFileName("fileName");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			sql = "insert into products values (?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, proId);
			pstmt.setString(2, proName);
			pstmt.setInt(3, unitPrice);
			pstmt.setString(4, description);
			pstmt.setString(5, manufacturer);
			pstmt.setString(6, category);
			pstmt.setInt(7, noOfStock);
			pstmt.setString(8, fileName);
			pstmt.execute();
			RequestDispatcher rd = request.getRequestDispatcher("./productList.do");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
