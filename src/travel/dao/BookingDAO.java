package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import travel.gui.LoginGui;
import travel.vo.BookingVO;

public class BookingDAO {

	public ArrayList<BookingVO> selectAll() { // 조회
		Connection conn = null; // connection 객체 생성
		Statement stmt = null; // SQL 등록, 실행
		ResultSet rs = null; // DB 결과값 받을 공간
		ArrayList<BookingVO> blist = null;
		try {
			conn = DBConn.getConnection();
			stmt = conn.createStatement(); // stmt 사용준비
			// sql 사용준비
			String sql = "select * from booking "
					+ "where custid = " + LoginGui.custid;

			rs = stmt.executeQuery(sql); // sql을 실행한 값을
			// rs에 담아줌
			blist = new ArrayList<BookingVO>();
			while (rs.next()) {
				BookingVO bvo = new BookingVO();
				bvo.setBookingid(rs.getInt("bookingid"));
				bvo.setFlightid(rs.getInt("flightid"));
				bvo.setFromcity(rs.getString("fromcity"));
				bvo.setTocity(rs.getString("tocity"));
				bvo.setFromdate(rs.getString("fromdate"));
				bvo.setTodate(rs.getString("todate"));
				bvo.setPrice(rs.getInt("price"));
				bvo.setCustid(rs.getInt("custid"));

				blist.add(bvo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(stmt, rs);
		}
		return blist;
	}

	public int insert(BookingVO bvo) {
		// insert into book values(bvo);
		Connection conn = null; // DB 연결
		PreparedStatement pstmt = null; // sql문 실행
		int result = 0; // 결과 값 -> 실행된 행의 수
		try {
			conn = DBConn.getConnection();
			String sql = "insert into booking "
					+ "(bookingid, flighid, fromcity, tocity,fromdate, todate, price, custid) "
					+ "values (orderid_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, bvo.getBookingid());
			pstmt.setInt(2, bvo.getFlightid());
			pstmt.setString(3, bvo.getFromcity());
			pstmt.setString(4, bvo.getTocity());
			pstmt.setString(5, bvo.getFromdate());
			pstmt.setString(6, bvo.getTodate());
			pstmt.setInt(7, bvo.getPrice());
			pstmt.setInt(7, bvo.getCustid());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}

		return result;

	}
	
	
	public int insert2(BookingVO bvo) {
		//insert into book values(bvo);
		Connection conn = null; //DB 연결
		PreparedStatement pstmt = null; //sql문 실행
		int result=0; //결과 값 -> 실행된 행의 수
		try {
			conn = DBConn.getConnection();
			String sql = "insert into booking "
					+ "(bookingid, flightid, fromcity, tocity, fromdate, todate, price, custid) "
					+ "values (bookingid_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1, bvo.getBookingid());
			pstmt.setInt(1, bvo.getFlightid());
			pstmt.setString(2, bvo.getFromcity());
			pstmt.setString(3, bvo.getTocity());
			pstmt.setString(4, bvo.getFromdate());
			pstmt.setString(5, bvo.getTodate());
			pstmt.setInt(6, bvo.getPrice());
			pstmt.setInt(7, bvo.getCustid());
			System.out.println(bvo.getFlightid()+ " "
					+ bvo.getFromcity()+ " "
					+bvo.getTocity()+ " "
					+bvo.getFromdate()+ " "
					+bvo.getTodate()+ " "
					+bvo.getPrice()+ " "
					+bvo.getCustid());
			result =  pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
		return result;
	}
	

	
	public int delete(int bookingid) {
		//insert into book values(bvo);
		Connection conn = null;
		Statement stmt = null;
		int result=0;
		try {
			conn = DBConn.getConnection();
			
			String sql = "delete from booking "
					+ "where bookingid = "+bookingid; 
			stmt = conn.createStatement();
			
			
			result =  stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(stmt, null);
		}
		
		return result;
	}	
	
	
	
	
	

	public void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}

	public void close(Statement stmt, ResultSet rs) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
}