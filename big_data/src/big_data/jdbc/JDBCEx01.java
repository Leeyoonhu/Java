package big_data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx01 {
	public static void main(String[] args) {
//		드라이버 로딩	
//		자바 응용프로그램과 JDBC 연결  (작업 후에는 close로 닫아줘야함)
//		Connection conn = DriverManager.getConnection(db위치, 유저명, 비밀번호);
//		Statement 객체 생성 
//		Statement stmt = conn.createStatement();
//		query 실행 => Select * from book; 
//		ResultSet rs = stmt.executeQuery("SELECT * FROM BOOK");
//		SQL문을 실행할 때 필요한 인자를 동적으로 설정 => PreparedStatement
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false";
		String user = "scott";
		String pw = "tiger";
		String sql = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pw);
			Statement stmt = conn.createStatement();
			// 데이터를 새로 추가한 후에 조회
			sql = String.format("delete from book where bookid = %d", 90);
			stmt.executeUpdate(sql); // insert into로 데이터 추가, 몇개의 행이 추가되었는지 int형 변수로 참조해주면 볼 수 있음
			sql = String.format("SELECT * FROM BOOK");
			// 데이터 조회 문장
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) { // 커서가 행 이동 rs.next();, 다음 행으로 이동 가능한경우에는 출력
				System.out.printf("%s %s %s %s\n", rs.getString("BookID"), rs.getString("BookName"),
						rs.getString("PUBLISHER"), rs.getString(4));
			}
			System.out.println();
			
//			rs = stmt.executeQuery(sql);	// select 를 실행해서 데이터 조회
//			rs.next();
//			System.out.printf("%s %s %s %s\n", rs.getString(1), rs.getString(2),
//					rs.getString(3), rs.getString(4));
//			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.getMessage();
		}

	}
}
