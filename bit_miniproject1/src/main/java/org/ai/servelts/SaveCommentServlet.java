package org.ai.servelts;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;

/**
 * Servlet implementation class SaveCommentServlet
 */
@WebServlet("/Members/saveComment.do")
public class SaveCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveCommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		saveCommentDo(request, response);
	}

	public void saveCommentDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		<!-- 댓글을 달면, 글번호(number), 글작성자(nickname을 writer로), 댓글내용은 새로받은 내용(comment), 댓글 단 시간이 regDate -->
//		Comment DB에 작성
		request.setCharacterEncoding("utf-8");
		int number = Integer.parseInt(request.getParameter("number"));
		String writer = request.getParameter("writer");
		String comment = request.getParameter("comment");

		String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
		String sql = null;
		String user = "root";
		String password = "1234";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			sql = "insert into comment value(?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, writer);
			pstmt.setString(3, comment);
			pstmt.executeUpdate();
			String viewUrl = String.format("./boardView.jsp?number=%d", number);
			response.sendRedirect(viewUrl);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
