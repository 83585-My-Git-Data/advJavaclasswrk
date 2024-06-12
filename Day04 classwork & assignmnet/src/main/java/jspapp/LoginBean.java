package jspapp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBean {
	private String email;
	private String password;
	private User user;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public LoginBean() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void authenticate() {
		String DB_URL = "jdbc:mysql://localhost:3306/election_db";
		String DB_USER = "root";
		String DB_PASS = "manager";
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM users WHERE email=? AND password=?";
			try(PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, this.email);
				stmt.setString(2, this.password);
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
						this.user = new User(id, firstName, lastName, email, password, dob, status, role);						
					}
					else
						this.user = null;
				} // rs.close();
			} // stmt.close();
		} // con.close();
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
}





