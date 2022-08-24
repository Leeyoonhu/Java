package big_data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exercise04 {
	// 입력한 값이 DB에 저장이 되고, 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false";
		String user = "scott";
		String pw = "tiger";
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int deptno = 0;	int salary = 0;	String name = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		} 
		while(true) {
			System.out.println("사번, 이름, 월급 순서로 입력하시오");
			deptno = scan.nextInt();
			name = scan.next();
			salary = scan.nextInt();
			try {
				sql = "insert into emp1 (deptno, name, salary) values (?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, name);
				pstmt.setInt(3, salary);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			System.out.println("정보가 추가되었습니다.");
			System.out.println("입력을 계속하시겠습니까? (y/n)");
			String yesOrNo = null;
			yesOrNo = scan.next();
			if(yesOrNo.equals("n")) {
				break;
			}
		}
		
	}
}
