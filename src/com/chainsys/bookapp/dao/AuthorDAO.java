package com.chainsys.bookapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.chainsys.bookapp.model.Author;
import com.chainsys.connection.util.ConnectionUtil;

public class AuthorDAO {
	/**
	 * 
	 * @param id
	 * @param name
	 * @param dateofbirth
	 * @throws SQLException
	 */
	public static void addAuthor(int id, String name, LocalDate dateofbirth)
			throws SQLException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "insert into author(id,name,dateofbirth) values(?,?,?) ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setDate(3, Date.valueOf(dateofbirth));
		int rows = preparedStatement.executeUpdate();
		System.out.println("rows inserted:" + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public static ArrayList<Author> authorselect() throws SQLException {

		Connection connection = ConnectionUtil.getconnection();
		String sql = "select id,name from author order by id asc ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rset = preparedStatement.executeQuery();
		ArrayList<Author> arrayList = new ArrayList<Author>();

		while (rset.next()) {
			Author author = new Author();
			author.setId(rset.getInt("id"));
			author.setName(rset.getString("name"));
			arrayList.add(author);

		}
		return arrayList;

	}

}
