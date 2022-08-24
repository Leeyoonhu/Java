package big_data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx02 {
	public static void main(String[] args) {
		// Statement 말고 PreparedStatement 사용할 것
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false";
		String user = "scott";
		String pw = "tiger";
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
			sql = "insert into book values (?,?,?,?)"; // bookid가 ?번부터 ?번까지
			pstmt = conn.prepareStatement(sql);// statement랑은 다르게 쿼리문 매개변수로 받아서 먼저 사용해서 속도도빠름
			pstmt.setInt(1, 35);
			pstmt.setString(2, "행복한 왕자");
			pstmt.setString(3, "와일드출판사");
			pstmt.setInt(4, 12000);
			pstmt.executeUpdate();
			// insert 는 삽입만 가능, 해당 쿼리의 값을 조회하고 싶으면 조회문으로 바꿔서 ..
			sql = "select * from book where bookid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 33);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.printf("%s %s %s %s\n", rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
	}
}
