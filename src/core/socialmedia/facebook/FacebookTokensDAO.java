package core.socialmedia.facebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.socialmedia.TokenAPI;
import database.DatabaseManager;

public class FacebookTokensDAO {
	
	public static void insertOrReplaceToken(TokenAPI token){
		try {
			DatabaseManager db = new DatabaseManager();
			Connection con = db.getConnection();

			PreparedStatement stmt = con
					.prepareStatement("REPLACE INTO facebook_tokens (user_id,facebook_token,facebook_profile_id) "
							+ "VALUES (?,?,?)");
			stmt.setInt(1, token.getUserId());
			stmt.setString(2, token.getAccessToken());
			stmt.setString(3, token.getProfileId());
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TokenAPI getTokenFromUserId(int userId) {
		TokenAPI myToken = null;
		try {
			DatabaseManager db = new DatabaseManager();
			Connection con = db.getConnection();

			PreparedStatement stmt = con
					.prepareStatement("SELECT * FROM facebook_tokens WHERE user_id = ?");
			stmt.setInt(1, userId);			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				userId = rs.getInt("user_id");
				myToken = new TokenAPI(rs.getInt("user_id"), rs.getString("facebook_token"), rs.getString("facebook_profile_id"));
			}
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return myToken;
		}
	}
}
