package travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import travel.vo.BookingVO;
import travel.vo.FlightVO;

public class FlightDAO {
	public ArrayList<FlightVO> selectAll(){ //조회
		Connection conn = null; //connection 객체 생성
		Statement stmt = null;  //SQL 등록, 실행
		ResultSet rs = null;    //DB 결과값 받을 공간
		ArrayList<FlightVO> flist = null;
		try {
			conn = DBConn.getConnection();
			stmt = conn.createStatement(); //stmt 사용준비 
											//sql 사용준비
			String sql = "select * from flight "
					+ "order by flightid";
			rs = stmt.executeQuery(sql); //sql을 실행한 값을 
										//rs에 담아줌
			flist = new ArrayList<FlightVO>();
			while(rs.next()) {
				FlightVO bvo = new FlightVO();
				bvo.setFlightid(rs.getInt("flightid"));
				bvo.setFromcity(rs.getString("fromcity"));
				bvo.setTocity(rs.getString("tocity"));
				bvo.setFromdate(rs.getString("fromdate"));
				bvo.setTodate(rs.getString("todate"));
				bvo.setPrice(rs.getInt("price"));
				
				
				flist.add(bvo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(stmt, rs);
		}
		return flist;
	}
	
	
	public ArrayList<FlightVO> selectSearch(String search1, String search2, String search3, String search4){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FlightVO> flist = null;
		try {
			conn = DBConn.getConnection();
			String sql = "select * from flight "
					+ "where fromcity like ? "
					+ "and tocity like ? "
					+ "and fromdate like ? "
					+ "and todate like ? "
					+ "order by price";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search1+"%");
			pstmt.setString(2, "%"+search2+"%");
			pstmt.setString(3, "%"+search3+"%");
			pstmt.setString(4, "%"+search4+"%");
			rs = pstmt.executeQuery();
			flist = new ArrayList<FlightVO>();
			while(rs.next()) {
				FlightVO bvo = new FlightVO();
				bvo.setFlightid(rs.getInt("flightid"));
				bvo.setFromcity(rs.getString("fromcity"));
				bvo.setTocity(rs.getString("tocity"));
				bvo.setFromdate(rs.getString("fromdate"));
				bvo.setTodate(rs.getString("todate"));
				bvo.setPrice(rs.getInt("price"));
				
				flist.add(bvo);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt, rs);
		}
		return flist;
	}
	
	
	
	
	//-----------------------삽입---------------------
	public int insert(FlightVO bvo) {
		//insert into book values(bvo);
		Connection conn = null; //DB 연결
		PreparedStatement pstmt = null; //sql문 실행
		int result=0; //결과 값 -> 실행된 행의 수
		try {
			conn = DBConn.getConnection();
			String sql = "insert into flight "
					+ "(flightid, fromcity, tocity, fromdate, todate, price) "
					+ "values (? , ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1, bvo.getBookid());
			pstmt.setInt(1, bvo.getFlightid());
			pstmt.setString(2, bvo.getFromcity());
			pstmt.setString(3, bvo.getTocity());
			pstmt.setString(4, bvo.getFromdate());
			pstmt.setString(5, bvo.getTodate());
			pstmt.setInt(6, bvo.getPrice());
			
			result =  pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
		
		return result;
	}
	
	
	
	
	
	
	public int update(FlightVO bvo) {
		//insert into book values(bvo);
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
			conn = DBConn.getConnection();
			String sql = "update flight "
					+ "set fromcity = ?, tocity = ?, fromdate = ?, fromdate = ? , price = ?"
					+ "where flightid = ?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getFromcity());
			pstmt.setString(2, bvo.getTocity());
			pstmt.setString(3, bvo.getFromdate());
			pstmt.setString(4, bvo.getFromdate());
			pstmt.setInt(5, bvo.getPrice());
			pstmt.setInt(6, bvo.getFlightid());
			
			result =  pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
		
		return result;
	}	
	
	public int delete(int flightid) {
		//insert into book values(bvo);
		Connection conn = null;
		Statement stmt = null;
		int result=0;
		try {
			conn = DBConn.getConnection();
			
			String sql = "delete from flight "
					+ "where flightid = " + flightid; 
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
	
	public void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			if(pstmt!=null) {
				pstmt.close();
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
