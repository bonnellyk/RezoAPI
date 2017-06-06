package core.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import database.DatabaseManager;

public class ConnectionDAO {
	
	public static void insertNewConnectionRequest(UserConnection userConn) {
		try {
		DatabaseManager db = new DatabaseManager();
		Connection con = db.getConnection();
		
		PreparedStatement stmt;
		
			stmt = con.prepareStatement("INSERT INTO connection (first_user_id,second_user_id,request_date,position_lat,position_lon) "
					+ "VALUES (?,?,?,?,?)");
			
			stmt.setInt(1, userConn.getFirstUserId());
			stmt.setInt(2, userConn.getSecondUserId());
			stmt.setTimestamp(3, userConn.getRequestDate());
			stmt.setDouble(4, userConn.getLatitude());
			stmt.setDouble(5, userConn.getLongitude());			
			
			stmt.execute();		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}							
	}
	
	public static void acceptConnectionRequest(int firstUserId, int secondUserId, Timestamp acceptDate) {
		try {
			DatabaseManager db = new DatabaseManager();
			Connection con = db.getConnection();
			
			PreparedStatement stmt;
			
				stmt = con.prepareStatement("UPDATE connection SET accepted = 1, accept_date = ? WHERE first_user_id = ? AND second_user_id = ?");
				stmt.setTimestamp(1, acceptDate);
				stmt.setInt(2, firstUserId);
				stmt.setInt(3, secondUserId);
				
				stmt.execute();		
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
	}
}
