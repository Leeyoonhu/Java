package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Temp02 {
	static String sql = null;
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Members> al = null;
		Scanner scan = new Scanner(System.in);
		Members m = null;
		int ID = 0;
	
		conn = getConnectivity(url, user, password);
		
		EXIT:
		while(true) {
			System.out.println("========================================================");
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.모두 보기 6.종료");
			System.out.println("========================================================");
			System.out.println("메뉴를 선택하시오 >>");
			int menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("비밀번호, 이름, 이메일, 전화번호 순으로 입력하시오");
				m = new Members(scan.next(), scan.next(), scan.next(), scan.next());
				insertMember(conn, pstmt, m);
				break;
			case 2:
				System.out.println("검색할 회원의 이름을 입력하시오");
				al = getMembers(conn, pstmt, rs, scan.next());
				if(al.isEmpty()) {
					System.out.println("존재하지 않는 회원입니다.");
				}
				else {
					showAll(al);
				}
				break;
			case 3:
				System.out.println("수정할 회원의 아이디와 비밀번호를 입력하시오");
				ID = scan.nextInt();
				if(isMember(conn, pstmt, rs, ID, scan.next())) {
					System.out.println("비밀번호, 이름, 이메일, 전화번호 순으로 입력하시오");
					m = new Members(ID, scan.next(), scan.next(), scan.next(), scan.next());
					updateMembers(conn, pstmt, m);
				}
				else {
					System.out.println("존재하지 않는 회원입니다.");
				}
				break;
				
			case 4:
				System.out.println("삭제할 회원의 아이디와 비밀번호를 입력하시오");
				ID = scan.nextInt();
				if(isMember(conn, pstmt, rs, ID, scan.next())) {
					deleteMembers(conn, pstmt, ID);
				}
				else {
					System.out.println("존재하지 않는 회원입니다.");
				}
				break;
			case 5:
				al = getMemberListAll(conn, pstmt, rs);
				showAll(al);
				break;
			case 6:
				break EXIT;
			}
		}
		
		
		
	}
	
	public static Connection getConnectivity(String url, String user, String password) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static boolean isMember(Connection conn, PreparedStatement pstmt, ResultSet rs, int userId, String userPwd) {
		try {
			sql = "select * from members where userID = ? and userPwd = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if(rs.next() == false) {
				return false;
			}
			else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static void showAll(List<Members> al) {
		for(Members m : al) {
			System.out.println(m.toString());
		}
	}
	
	public static List<Members> getMembers(Connection conn, PreparedStatement pstmt, ResultSet rs, String userName){
		List<Members> mList = new ArrayList<Members>();
		try {
			sql = "select * from members where userName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Members m = new Members(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				mList.add(m);
			}
			return mList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static int insertMember(Connection conn, PreparedStatement pstmt, Members mem) {
		int check = 0;
		try {
			sql = "insert into members (userPwd, userName, email, phoneNo) values "
					+ "(?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mem.getUserPwd());
				pstmt.setString(2, mem.getUserName());
				pstmt.setString(3, mem.getEmail());
				pstmt.setString(4, mem.getPhoneNo());
				check = pstmt.executeUpdate();
				return check;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return check;
		}
	}
	
	public static int updateMembers(Connection conn, PreparedStatement pstmt, Members mem) {
		int check = 0;
		try {
			sql = "update members set userPwd = ?, userName = ?, email = ?, phoneNo = ? where userID = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getUserPwd());
			pstmt.setString(2, mem.getUserName());
			pstmt.setString(3, mem.getEmail());
			pstmt.setString(4, mem.getPhoneNo());
			pstmt.setInt(5, mem.getUserID());
			check = pstmt.executeUpdate();
			return check;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return check;			
		}
	}
	
	public static int deleteMembers(Connection conn, PreparedStatement pstmt, int userId) {
		int check = 0;
		try {
			sql = "delete from members where userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			check = pstmt.executeUpdate();
			return check;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return check;
		}
	}
	
	public static List<Members> getMemberListAll(Connection conn, PreparedStatement pstmt, ResultSet rs){
		List<Members> mList = new ArrayList<Members>();
		try {
			sql = "select * from members";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Members m = new Members(rs.getInt(1), rs.getString(2), rs.getString(3)
						, rs.getString(4), rs.getString(5), rs.getString(6));
				mList.add(m);
			}
			return mList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
