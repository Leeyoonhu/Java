package big_data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exercise02 {
	//키보드에서 사원 이름, 또는 성을 입력받고 해당 사원과 같은 부서 일하는 사원
	 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/hr?useSSL=false&allowPublicKeyRetrieval=true";
		String user = "hr";
		String pw = "hr";
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
			sql = String.format("select * from employees where department_id in"
					+ " (select department_id from employees where first_name = ? or last_name = ?)");
			pstmt = conn.prepareStatement(sql);
			name = scan.next();
			pstmt.setString(1, name);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.printf("%s %s %s %s %s %s %s %s %s %s %s\n", rs.getString(1), rs.getString(2)
						, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
						, rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)
						, rs.getString(11));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
