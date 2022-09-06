package com.conan.servlets;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conan.vo.*;
/**
 * Servlet implementation class ProductListController
 */
@WebServlet("/products/productList.do")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		DB에서 상품 목록을 가져와서 컬렉션에 담아 화면 페이지 이동
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
		String sql = null;
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Products> pList = new ArrayList<Products>();
		String uploadedFolder = null;
		ArrayList<String> uploadedFolderList = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			sql = "select * from products";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pList.add(new Products(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
			}
//			db에 저장된 이미지를 upload폴더 안에 쓰고
//			upload폴더 안에 있는 이미지를 불러온다?
			uploadedFolder = request.getServletContext().getContextPath()+"/upload/";
			
//			이미지가 있는 위치를 업로드폴더안에..??
			request.setAttribute("imgUrl", uploadedFolder);
			request.setAttribute("pl", pList);
			
			RequestDispatcher rd = request.getRequestDispatcher("./productList.jsp");
			rd.forward(request, response);
			 
		} catch (Exception e) {
			e.printStackTrace();
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
