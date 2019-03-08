package com.chainsys.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.chainsys.bookapp.model.RegisterClass;
import com.chainsys.connection.util.ConnectionUtil;

public class ForgetDAO {
	/**
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public static RegisterClass forgetSelect(String email) throws SQLException {

		Connection connection = ConnectionUtil.getconnection();
		String sql = "select username,password  from register where email=? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet rset = preparedStatement.executeQuery();

		RegisterClass register = new RegisterClass();
		while (rset.next()) {

			register.setUsername(rset.getString("username"));
			register.setPassword(rset.getString("password"));
			System.out.println(register.getUsername());

		}
		return register;

	}

}
