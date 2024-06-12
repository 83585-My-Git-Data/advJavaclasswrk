package com.sunbeam.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sunbeam.pojos.User;

public class UserDaoImpl extends Dao implements UserDao {
	public UserDaoImpl() throws Exception {
	}
	public User findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					int id = rs.getInt("id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					email = rs.getString("email");
					String password = rs.getString("password");
					Date dob = rs.getDate("dob");
					int status = rs.getInt("status");
					String role = rs.getString("role");
					User u = new User(id, firstName, lastName, email, password, dob, status, role);
					return u;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}
	
	public User findById(int id) throws Exception {
		String sql = "SELECT * FROM users WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					id = rs.getInt("id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					String email = rs.getString("email");
					String password = rs.getString("password");
					Date dob = rs.getDate("dob");
					int status = rs.getInt("status");
					String role = rs.getString("role");
					User u = new User(id, firstName, lastName, email, password, dob, status, role);
					return u;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}
	
	public int save(User user) throws Exception {
		String sql = "INSERT INTO users VALUES(default, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setDate(5, user.getBirth());
			stmt.setInt(6, user.getStatus());
			stmt.setString(7, user.getRole());
			int cnt = stmt.executeUpdate();
			return cnt;
		} //stmt.close();
	}

	public int updateStatus(int userId, boolean voted) throws Exception {
		String sql = "UPDATE users SET status=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, (voted ? 1 : 0));
			stmt.setInt(2, userId);
			int cnt = stmt.executeUpdate();
			return cnt;
		} // stmt.close();
	}

	public int updatePassword(int userId, String newPassword) throws Exception {
		String sql = "UPDATE users SET password=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, newPassword);
			stmt.setInt(2, userId);
			int cnt = stmt.executeUpdate();
			return cnt;
		} // stmt.close();
	}

	public int deleteById(int id) throws Exception {
		String sql = "DELETE FROM users WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int cnt = stmt.executeUpdate();
			return cnt;
		} //stmt.close();
	}

	public int update(User user) throws Exception {
		String sql = "UPDATE users SET first_name=?, last_name=?, email=?, dob=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setDate(4, user.getBirth());
			stmt.setInt(5, user.getId());
			int cnt = stmt.executeUpdate();
			return cnt;
		} //stmt.close();
	}
}
