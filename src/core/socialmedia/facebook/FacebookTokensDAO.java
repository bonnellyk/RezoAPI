package core.socialmedia.facebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseManager;

public class FacebookTokensDAO {
	
	public static void insertOrReplaceToken(int userId, String token, String profileId){
		try {
			DatabaseManager db = new DatabaseManager();
			Connection con = db.getConnection();

			PreparedStatement stmt = con
					.prepareStatement("REPLACE INTO facebook_tokens (user_id,facebook_token,facebook_profile_id) "
							+ "VALUES (?,?,?)");
			stmt.setInt(1, userId);
			stmt.setString(2, token);
			stmt.setString(3, profileId);
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
