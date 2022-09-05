package org.ai.members;

import java.io.IOException;
import java.net.HttpCookie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ai.beans.Members;
/**
 * Servlet implementation class LoginProc
 */
@WebServlet("/member/loginProc.do")
public class LoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProc() {
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
		System.out.println("doPost()에 왔다");
		actionDo(request, response);
	}

	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo()에 왔다");
		ArrayList<Members> memList = new ArrayList<Members>();
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		String url ="jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
		String sql = null;
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			sql = "select * from members";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				memList.add(new Members(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)
						, rs.getString(5), rs.getString(6)));
			}
			
			for(int i = 0; i < memList.size(); i++) {
				if(userId.equals(memList.get(i).getUserId()) && userPwd.equals(memList.get(i).getUserPwd())) {
//					Servlet에서 session에 저장하려면 HttpSession 인터페이스 사용 해서 request.getSession() 해주어야함
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("userId", userId);
					httpSession.setAttribute("userPwd", userPwd);
					Cookie cookie = new Cookie("userName", memList.get(i).getUserName());
					response.addCookie(cookie);
					response.sendRedirect("./loginResult.jsp");
				}
			}
			response.sendRedirect("./loginForm.jsp");
		} catch (Exception e){
			e.printStackTrace();
		}
	}	
}
