package big_data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

class Members {
	private int userID;
	private String userPwd;
	private String userName;
	private String email;
	private String phoneNo;
	private String regDate;

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

	public Members(String userName) {
		this.userName = userName;
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

public class Exercise05 {
	// workbench에서 members를 가져와서
	// autoincrement 를 갖는 userID
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false";
		String user = "scott";
		String pw = "tiger";
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Members m;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true) {
			System.out.println("=================================================");
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.모두 보기 6.종료");
			System.out.println("=================================================");
			System.out.println("메뉴를 선택하시오 >> ");
			int choice = scan.nextInt();
			if (choice == 1) {
				try {
					System.out.println("비밀번호, 이름, 이메일, 전화번호 순으로 입력하시오");
					sql = "insert into members (userPwd, userName, email, phoneNo) values (?, ?, ?, ?)";
					String pwd = scan.next();
					String name = scan.next();
					String email = scan.next();
					String phoneNo = scan.next();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pwd);
					pstmt.setString(2, name);
					pstmt.setString(3, email);
					pstmt.setString(4, phoneNo);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (choice == 2) {
				try {
					System.out.println("검색할 회원의 이름을 입력하시오>>");
					String name = scan.next();
					sql = "select * from members where userName = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, name);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						m = new Members(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6));
						System.out.println(m.toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (choice == 3) {
				try {
					System.out.println("수정할 회원 아이디와 비밀번호를 입력하시오>>");
					int ID = scan.nextInt();
					String pwd = scan.next();
					sql = "select * from members where userid = ? and userPwd = ?";
					// 만약 members 테이블에 없는 id나 비밀번호를 입력시 판독해야함
					// 테이블에 맞는 id나 비밀번호가 없다면
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, ID);
					pstmt.setString(2, pwd);
					rs = pstmt.executeQuery(); // resultSet에 쿼리문 실행값을 넣는것으로는 예외가 발생하지않음
					if (rs.next() == false) {
						System.out.println("존재하지 않는 회원입니다.");
					} else {
						System.out.println("비밀번호, 이름, 이메일, 전화번호 순으로 입력하시오");
						String changedPwd = scan.next();
						String name = scan.next();
						String email = scan.next();
						String phoneNo = scan.next();
						sql = "update members set userPwd = ?, userName = ?, email = ?, phoneNo = ? where userid = ? and userPwd = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, changedPwd);
						pstmt.setString(2, name);
						pstmt.setString(3, email);
						pstmt.setString(4, phoneNo);
						pstmt.setInt(5, ID);
						pstmt.setString(6, pwd);
						pstmt.executeUpdate();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (choice == 4) {
				try {
					System.out.println("삭제할 회원 아이디와 비밀번호를 입력하시오>>");
					int ID = scan.nextInt();
					String pwd = scan.next();
					sql = "select * from members where userid = ? and userPwd = ?";
					// 만약 members 테이블에 없는 id나 비밀번호를 입력시 판독해야함
					// 테이블에 맞는 id나 비밀번호가 없다면
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, ID);
					pstmt.setString(2, pwd);
					rs = pstmt.executeQuery(); // resultSet에 쿼리문 실행값을 넣는것으로는 예외가 발생하지않음
					if (rs.next() == false) {
						System.out.println("존재하지 않는 회원입니다.");
					} else {
						sql = "delete from members where userid = ? and userPwd = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, ID);
						pstmt.setString(2, pwd);
						pstmt.executeUpdate();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (choice == 5) {
				try {
					sql = "select * from members";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						m = new Members(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6));
						System.out.println(m.toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (choice == 6) {
				break;
			}
		}
	}
}
