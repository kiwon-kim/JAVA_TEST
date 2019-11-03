package travel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection conn = null;
	
	private DBConn() {}
	

	public static Connection getConnection() {
		
		if(conn == null) {
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@10.10.16.54:1521:xe";
			String id = "android";
			String pwd = "1234";
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, id, pwd);
				System.out.println("DB 연결 확인");
			} catch (ClassNotFoundException e) {
				System.out.println("driver load fail");
				e.printStackTrace();
			}
			catch (SQLException e) {
				System.out.println("db connection fail");
				e.printStackTrace();
			}
			
			
		}
		return conn;
	}
}
