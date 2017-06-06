package core.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import database.DatabaseManager;

public class UserDAO {

	public static ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		try {
			DatabaseManager db = new DatabaseManager();
			Connection con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM user");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setBirthday(rs.getTimestamp("birthday"));
				user.setCreationDate(rs.getTimestamp("creation_date"));	
				user.setEmail(rs.getString("email"));
				users.add(user);
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

	public static void addNewUser(User user) {
		try {
			DatabaseManager db = new DatabaseManager();
			Connection con = db.getConnection();

			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO user (firstname,lastname,birthday,creation_date,email) "
							+ "VALUES (?,?,?,?,?)");
			stmt.setString(1, user.getFirstname());
			stmt.setString(2, user.getLastname());
			stmt.setTimestamp(3, user.getBirthday());
			stmt.setTimestamp(4, user.getCreationDate());
			stmt.setString(5, user.getEmail());
			stmt.execute();
			con.close();	
			
			int userId = getUserIdOfNewUser(user.getEmail());
			UserDAO.bindEmail(userId, user.getEmail());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void bindEmail(int userId, String email) {
		try {
			DatabaseManager db = new DatabaseManager();
			Connection con = db.getConnection();
	
			PreparedStatement stmt = con
					.prepareStatement("REPLACE INTO email_binding (user_id,email) "
							+ "VALUES (?,?)");
			stmt.setInt(1, userId);
			stmt.setString(2, email);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int getUserIdOfNewUser(String email) {
		int userId = -1;
		try {
			DatabaseManager db = new DatabaseManager();
			Connection con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement("SELECT id FROM user WHERE email = ? LIMIT 1");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				userId = rs.getInt("id");
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}
	
	public static int getUserId(String email) {
		int userId = -1;
		try {
			DatabaseManager db = new DatabaseManager();
			Connection con = db.getConnection();

			PreparedStatement stmt = con.prepareStatement("SELECT user_id FROM email_binding WHERE email = ? LIMIT 1");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				userId = rs.getInt("user_id");
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}
	
	
}
