package big_data.jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCEx03 {
	// 이미지 가져온 후 복사하기
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false";
		String user = "scott";
		String pw = "tiger";
		String sql = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
			sql = "insert into images values (?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "conan");
			//스트림으로 이미지 가져오기
			FileInputStream fin = new FileInputStream("c:/temp/conan.jpg");
			ps.setBinaryStream(2, fin, fin.available()); // fin이 사용가능할때까지
//			int i = ps.executeUpdate();
//			System.out.println(i + "개의 레코드가 삽입됨");
			
			sql = "Select * from images";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Blob b = rs.getBlob(2); // 2번째 열 데이터, images의 2번째 열 데이터는 photos
				byte[] bArray = b.getBytes(1, (int)b.length()); // 2번째 열의 데이터를 배열 bArray에 저장
				FileOutputStream fos = new FileOutputStream("c:/temp/conan1.jpg"); 
				// fos의 파일 경로 생성
				fos.write(bArray);
				// photos에서 읽어온 정보가 담긴 bArray를 c:/temp/conan1.jpg 에 저장
				fos.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
