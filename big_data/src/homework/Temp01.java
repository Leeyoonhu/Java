package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class Members {
	private int userID;
	private String userPwd, userName, email, phoneNo, regDate;
	public Members(int userID, String userPwd, String userName, String email, String phoneNo, String regDate) {
		this.userID = userID;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.regDate = regDate;
	}
	
	
	
	public Members(int userID, String userPwd, String userName, String email, String phoneNo) {
		this.userID = userID;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phoneNo = phoneNo;
	}



	public Members(String userPwd, String userName, String email, String phoneNo) {
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.phoneNo = phoneNo;
	}



	public int getUserID() {
		return userID;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Members [userID=" + userID + ", userPwd=" + userPwd + ", userName=" + userName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", regDate=" + regDate + "]";
	}
}

public class Temp01 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false";
		String user = "scott";
		String password = "tiger";
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OUT:
		while(true) {
			System.out.println("=============================================================");
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.모두 보기 6.종료");
			System.out.println("=============================================================");
			System.out.println("메뉴를 선택하시오 >> ");
			int menu = scan.nextInt();
			switch(menu) {
			case 1:
				try {
					System.out.println("비밀번호, 이름, 이메일, 전화번호 순으로 입력하시오");
					String userPwd = scan.next(); String userName = scan.next(); 
					String email = scan.next(); String phoneNo = scan.next();
					sql = "insert into members (userPwd, userName, email, phoneNo) values "
							+ "(?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userPwd);
					pstmt.setString(2, userName);
					pstmt.setString(3, email);
					pstmt.setString(4, phoneNo);
					pstmt.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					System.out.println("검색할 회원의 이름을 입력하시오>>");
					String userName = scan.next();
					sql = "select * from members where userName = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userName);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						Members m = new Members(rs.getInt(1), rs.getString(2), rs.getString(3)
								, rs.getString(4), rs.getString(5), rs.getString(6));
						System.out.println(m.toString());
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println("수정할 회원 아이디와 비밀번호를 입력하시오>>");
					int userID = scan.nextInt();
					String userPwd = scan.next();
					sql = "Select * from members where userID = ? and userPwd = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, userID);
					pstmt.setString(2, userPwd);
					rs = pstmt.executeQuery();
					if(rs.next() == false) {
						System.out.println("존재하지 않는 회원입니다.");
					}
					else {
						System.out.println("수정할 회원의 비밀번호, 이름, 이메일, 전화번호 순으로 입력하시오.");
						String updatePwd = scan.next();
						String updateName = scan.next();
						String updateEmail = scan.next();
						String updatePhoneNo = scan.next();
						sql = "Update members set userPwd = ?, userName = ?,"
								+ " email = ?, phoneNo = ? where userID = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, updatePwd);
						pstmt.setString(2, updateName);
						pstmt.setString(3, updateEmail);
						pstmt.setString(4, updatePhoneNo);
						pstmt.setInt(5, userID);
						pstmt.executeUpdate();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 4:
				try {
					System.out.println("삭제할 회원 아이디와 비밀번호를 입력하시오>>");
					int userID = scan.nextInt();
					String userPwd = scan.next();
					sql = "Select * from members where userID = ? and userPwd = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, userID);
					pstmt.setString(2, userPwd);
					rs = pstmt.executeQuery();
					if(rs.next() == false) {
						System.out.println("존재하지 않는 회원입니다.");
					}
					else {
						sql = "delete from members where userID = ? and userPwd = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, userID);
						pstmt.setString(2, userPwd);
						pstmt.executeUpdate();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 5:
				try {
					sql = "select * from members";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						Members m = new Members(rs.getInt(1), rs.getString(2), rs.getString(3)
								, rs.getString(4), rs.getString(5), rs.getString(6));
						System.out.println(m.toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				break OUT;
			}
		}
	}
}
