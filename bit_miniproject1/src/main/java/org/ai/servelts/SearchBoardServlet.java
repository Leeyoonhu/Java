package org.ai.servelts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;
import org.ai.beans.*;

import com.mysql.cj.jdbc.ha.BestResponseTimeBalanceStrategy;
/**
 * Servlet implementation class SearchBoardServlet
 */
@WebServlet("/Members/searchNoticeBoard.do")
public class SearchBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBoardServlet() {
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
		searchBoard(request, response);
		
	}
	public void searchBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String searchTitle = request.getParameter("searchTitle");
		String content = request.getParameter("content");
		String boardTitle = request.getParameter("boardTitle");
		content = "'%"+content+"%'";
		String title = null;
		String writer = null;
		String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
		String sql = null;
		String user = "root";
		String password = "1234";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board> bList = new ArrayList<Board>();
		ArrayList<Comment> cList = new ArrayList<Comment>();
		if(searchTitle.equals("제목")) {
			title = "title";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				sql = "select * from board where ? like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				rs = pstmt.executeQuery();
				while(rs.next()){
					bList.add(new Board(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
							rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10).substring(0, 10)));
				}
				sql = "select number from comment";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					cList.add(new Comment(rs.getInt(1)));
				}
				request.setAttribute("bList", bList);
				request.setAttribute("cList", cList);
				response.sendRedirect("./noticeboardForm.jsp");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(searchTitle.equals("닉네임")) {
			title = "writer";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
