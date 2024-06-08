package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.SQLException;

import utils.DbUtil;

public class Dao implements AutoCloseable {
	protected Connection con;
	public Dao() throws Exception {
		con = DbUtil.getConnection();
	}
	public void close() {
		try {
			if(con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
