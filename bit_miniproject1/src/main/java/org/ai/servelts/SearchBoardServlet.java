package org.ai.servelts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;
import org.ai.beans.*;

import com.mysql.cj.Session;
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
		String content = null;
		String searchTitle = null;
		String boardTitle = null;
		HttpSession httpSession = null;
		int pages = Integer.parseInt(request.getParameter("pages"));
		if(pages == 1) {
			searchTitle = request.getParameter("searchTitle");
			request.getSession();
			content = request.getParameter("content");
			boardTitle = request.getParameter("boardTitle");
			httpSession.setAttribute(searchTitle, "searchTitle");
			httpSession.setAttribute(content, "content");
			httpSession.setAttribute(boardTitle, "boardTitle");
		}
		else if(pages > 1) {
			httpSession = request.getSession();
			searchTitle = (String)httpSession.getAttribute("searchTitle");
			content = (String)httpSession.getAttribute("content");
			boardTitle = (String)httpSession.getAttribute("boardTitle");
		}
		content = "%"+content+"%";
		String url = "jdbc:mysql://localhost:3306/miniProject1?useSSL=false&allowPublicKeyRetrieval=true";
		String sql = null;
		String user = "root";
		String password = "1234";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(searchTitle);
		System.out.println(content);
		ArrayList<Board> bList = new ArrayList<Board>();
		ArrayList<Board> bList2 = new ArrayList<Board>();
		ArrayList<Board> bList3 = new ArrayList<Board>();
		ArrayList<Comment> cList = new ArrayList<Comment>();
		int size = 0;
		// 페이지가 1번일때 2번이상일때
		if(searchTitle.equals("제목")) {
			sql = "select * from board where title like ?";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, content);
				rs = pstmt.executeQuery();
				while(rs.next()){
					bList.add(new Board(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
							rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10).substring(0, 10)));
				}
				Collections.reverse(bList);
				size = bList.size();
				
					if(bList.size() < 15){
						for(int i = 0; i < bList.size(); i++){
							bList2.add(bList.get(i));
						}
					}
				
				else {
					int firstBoard = (15 * pages) - 15;
					int lastBoard = 15 * pages;
					if(bList.size() < lastBoard) {
						for(int i = firstBoard; i < bList.size(); i++){
							bList2.add(bList.get(i));
						}
					}
					else {
						for(int i = firstBoard; i < lastBoard; i++){
							bList2.add(bList.get(i));
						}
					}
					
				}
				
				
				sql = "select number from comment";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					cList.add(new Comment(rs.getInt(1)));
				}
				
				httpSession.setAttribute("size", size);	
				httpSession.setAttribute("bList", bList2);
				httpSession.setAttribute("cList", cList);
				String redirect = String.format("./noticeboardSearchForm.jsp?pages=%d", pages);
				response.sendRedirect(redirect);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(searchTitle.equals("닉네임")) {
			sql = "select * from board where writer like ?";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, content);
				rs = pstmt.executeQuery();
				while(rs.next()){
					bList.add(new Board(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
							rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10).substring(0, 10)));
				}
				Collections.reverse(bList);
				size = bList.size();
				if(bList.size() < 15){
					for(int i = 0; i < bList.size(); i++){
						bList3.add(bList.get(i));
					}
				}
				else {
					int firstBoard = (15 * pages) - 15;
					int lastBoard = 15 * pages;
					if(bList.size() < lastBoard) {
						for(int i = firstBoard; i < bList.size(); i++){
							bList3.add(bList.get(i));
						}
					}
					else {
						for(int i = firstBoard; i < lastBoard; i++){
							bList3.add(bList.get(i));
						}
					}
					
				}
				sql = "select number from comment";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					cList.add(new Comment(rs.getInt(1)));
				}
				
				httpSession.setAttribute("size", size);	
				httpSession.setAttribute("bList", bList3);
				httpSession.setAttribute("cList", cList);
				String redirect = String.format("./noticeboardSearchForm.jsp?pages=%d", pages);
				response.sendRedirect(redirect);
				
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
