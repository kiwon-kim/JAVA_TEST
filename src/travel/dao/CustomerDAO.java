package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAO {
	public int login(int custid, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCustid = 0;
		try {
			conn = DBConn.getConnection();
			String sql = "select custid from customer "
					+ "where custid = ? "
					+ "and pwd = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				resultCustid = rs.getInt("custid");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
		return resultCustid;
	}
	
	
	
	public void close(Statement stmt, ResultSet rs) {
		try {
			if(stmt!=null) {
				stmt.close();
			}
			if(rs !=null) {
				rs.close();
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
}
