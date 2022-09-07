package org.ai.servelts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.ApplicationBufferHandler;

import javax.servlet.*;

import com.mysql.cj.Session;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;
import java.util.*;
import java.sql.*;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/Members/boardwrite.do")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
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
		boardWriteDo(request, response);
	}
	
	public void boardWriteDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		쿠키에 있는 nickName이 writer가 될 예정임
		ServletContext apllication = getServletContext();
//		가져올땐 실제경로, 보여줄땐 상대경로
		String path = apllication.getRealPath("/upload");
//		10KB
		int size = 1024 * 1024 * 10;
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy()); 
//		가져온 params setting
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String writer = multi.getParameter("writer");
		String imageFileName = multi.getOriginalFileName("imageFileName");
		String fileName = multi.getOriginalFileName("fileName");
		
// 		DB에 저장
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
			sql = "insert into board (title, content, writer, imageFileName, fileName) values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer);
			pstmt.setString(4, imageFileName);
			pstmt.setString(5, fileName);
			pstmt.execute();
			response.sendRedirect("./freeBoardForm.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
