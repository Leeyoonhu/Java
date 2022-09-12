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
/**
 * Servlet implementation class RecommendsSurvlet
 */
@WebServlet("/Members/recommendsProcess.do")
public class RecommendsSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendsSurvlet() {
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
		RecommendsDo(request, response);
	}
	
	public void RecommendsDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		number를 받아서 db에서 해당 number를 조회하고, 해당 number조회된 글의 추천수를 +1 해주고 다시 글로보냄
//		사용자는 해당 페이지에서 추천누르자마자 올라간것으로 보여야함
		int number = Integer.parseInt(request.getParameter("number"));
		String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
		String sql = "select * from board where number = ?";
		String user = "root";
		String password = "1234";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board> bList = new ArrayList<Board>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();
			while(rs.next()){
				bList.add(new Board(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
			int recommends = bList.get(0).getRecommends();
			recommends += 1;
			sql = "update board set recommends = ? where number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recommends);
			pstmt.setInt(2, number);
			pstmt.executeUpdate();
//			number를 파라미터로 다시 View로 쏴줘야함
			String redirect = String.format("./freeBoardView.jsp?number=%d", number); 
			response.sendRedirect(redirect);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
