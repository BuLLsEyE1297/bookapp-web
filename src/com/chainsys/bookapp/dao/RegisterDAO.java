package com.chainsys.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.bookapp.model.RegisterClass;
import com.chainsys.connection.util.ConnectionUtil;

public class RegisterDAO {
	/**
	 * 
	 * @param registerClass
	 * @throws SQLException
	 */
	public static void userinsert(RegisterClass registerClass)
			throws SQLException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "insert into register(username,email,password,gender,id) values(?,?,?,?,userregister_id_seq.nextval)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, registerClass.username);
		preparedStatement.setString(2, registerClass.email);
		preparedStatement.setString(3, registerClass.password);
		preparedStatement.setString(4, registerClass.gender);
		@SuppressWarnings("unused")
		int rows = preparedStatement.executeUpdate();
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public static RegisterClass search(String email, String password)
			throws SQLException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "select id from register where email=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet rset = preparedStatement.executeQuery();
		RegisterClass registerclass = new RegisterClass();
		while (rset.next()) {
			registerclass.id = rset.getInt("id");
		}

		return registerclass;
	}

}
