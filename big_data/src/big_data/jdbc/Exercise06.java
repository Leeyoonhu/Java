package big_data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise06 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false";
		String user = "scott";
		String password = "tiger";
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		int userId = 0;
		String userPwd = null;
		Members mem = null; 
		List<Members> al = null;
		conn = getConnectivity(url, user, password);


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					url, user , password);
		}catch(Exception e){}

		BREAK:
			while(true) {
				System.out.println("========================================");
				System.out.println("1.추가 2.조회 3.수정 4.삭제 5.모두보기 6.종료");
				System.out.println("========================================");
				System.out.println("메뉴를 선택하시오 >> ");
				menu = scan.nextInt();
				switch(menu) {
				case 1: //추가 insert into members
					System.out.println("비밀번호, 이름, 이메일, 번호 순으로 입력하시오 >> ");
					mem = new Members(scan.next(), scan.next(), scan.next(), scan.next());
					insertMember(conn, pstmt, mem);
					break;
				case 2: //조회 select * from members where username = ''
					System.out.println("검색할 회원의 이름을 입력하시오 >> ");
					al = getMembers(conn, pstmt, rs, scan.next()); 
					showAll(al); 
					break;
				case 3: //수정 아이디 비밀번호가 일치하는 경우(select ..) --> 수정 update members....
					System.out.println("수정할 회원 아이디와 비밀번호를 입력하시오 >> ");
					userId = scan.nextInt();
					userPwd = scan.next();
					if(isMember(conn, pstmt, rs, userId, userPwd)) {
						System.out.println("비밀번호, 이름, 이메일, 번호 순서대로 입력하시오 >> ");
						mem = new Members(userId, scan.next(), scan.next(), scan.next(), scan.next());
						updateMembers(conn, pstmt, mem);
					}
					else {System.out.println("존재하지 않는 회원입니다."); }
					break;
				case 4: //삭제 아이디 비밀번호가 일치하는 경우(select ..) --> 수정 delete from members....
					System.out.println("삭제할 회원 아이디와 비밀번호를 입력하시오 >> ");
					userId = scan.nextInt();
					userPwd = scan.next();
					if(isMember(conn, pstmt, rs, userId, userPwd)) {
						deleteMembers(conn, pstmt, userId);
					}
					else {System.out.println("존재하지 않는 회원입니다."); } 
					break;
				case 5: 
					al = getMemberListAll(conn, pstmt, rs); showAll(al); 
					break;
				case 6:
					break BREAK;
				}
			}
	}		

	// DB와 연결되는 Connection 반환
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
	
	//입력된 정보를 가진 회원의 존재여부를 확인하여 회원이면 true 아니면 false 
	public static boolean isMember(Connection conn, PreparedStatement pstmt, ResultSet rs, int userId, String userPwd) {
		try {
			String sql = "Select * from Members where userID = ? and userPwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
			// (isMember(conn, pstmt, rs, userId, userPwd) 에서 false 가 나오는중
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	//객체 리스트 정보 출력
	public static void showAll(List<Members> al) {
		for(Members m : al) {
			System.out.println(m.toString());
		}
	}
	
	//이름 검색 후 해당 이름 지닌 Members 객체 리스트 반환 ==> 없는 이름이면 없다, 있는 이름이면 있다
	public static List<Members> getMembers(Connection conn, PreparedStatement pstmt, ResultSet rs, String userName){
		List<Members> mList = new ArrayList<Members>() ;
		try {
			String sql = "select * from members where userName = ?";
			// userName 일때의 정보를 뽑아서 list에 add
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Members m = new Members(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)
						, rs.getString(5), rs.getString(6));
				mList.add(m);
			}
			return mList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	// 맴버 객체 정보를 테이블에 저장
	public static int insertMember(Connection conn, PreparedStatement pstmt, Members m) {
		try {
			String sql = "insert into Members (userPwd, userName, email, phoneNo) values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getUserName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getPhoneNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}
	
	// 회원 여부 판단후, 회원이면 튜플 수정 ==> 회원이면 맴버 정보가 다 같아야하니..
	public static int updateMembers(Connection conn, PreparedStatement pstmt, Members m) {
		// id, pwd가 같을 때 
		try {
			String sql = "update members set userPwd = ?, userName = ?, email = ?, phoneNo = ? where userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getUserName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getPhoneNo());
			pstmt.setInt(5, m.getUserID());
			pstmt.executeUpdate();
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}
	//회원인 정보에 해당하는 튜플 삭제
	public static void deleteMembers(Connection conn, PreparedStatement pstmt, int userId) {
		try {
			String sql = "delete from members where userID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 테이블에 저장된 정보들을 리스트객체에 저장 후 반환
	public static List<Members> getMemberListAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			List<Members> mList = new ArrayList<Members>();
			String sql = "select * from members";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Members m = new Members(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)
						, rs.getString(5), rs.getString(6));
				mList.add(m);
			}
			return mList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
