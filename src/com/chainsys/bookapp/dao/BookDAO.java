package com.chainsys.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.bookapp.model.Author;
import com.chainsys.bookapp.model.Book;
import com.chainsys.connection.util.ConnectionUtil;

public class BookDAO {
/**
 * 
 * @param id
 * @param name
 * @param price
 * @param author_id
 * @throws SQLException
 * @throws ClassNotFoundException
 */
	public static void addBook(int id, String name, int price, int author_id)
			throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "insert into book(id,name,price,author_id) values(?,?,?,?) ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setInt(3, price);
		preparedStatement.setInt(4, author_id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("rows inserted:" + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public static void updateBook(int id, int price) throws SQLException,
			ClassNotFoundException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "update book set price =? where id =?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, price);
		preparedStatement.setInt(2, id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("rows updated:" + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public static void deleteBook(int id) throws SQLException,
			ClassNotFoundException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "delete from book where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("rows deleted:" + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public static ArrayList<Book> selectBook(String name) throws SQLException,
			ClassNotFoundException {
		Connection connection = ConnectionUtil.getconnection();

		String sql = "select book.id,book.name,book.price,author.name as authorname from book join author on book.author_id=author.id where book.name=? order by id asc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		ResultSet rset = preparedStatement.executeQuery();
		ArrayList<Book> arrayList = new ArrayList<Book>();

		while (rset.next()) {
			Book book = new Book();
			book.author = new Author();
			book.id = rset.getInt("id");
			book.name = rset.getString("name");
			book.price = rset.getInt("price");
			book.author.setName(rset.getString("authorname"));
			arrayList.add(book);

		}

		ConnectionUtil.close(connection, preparedStatement, rset);
		return arrayList;
	}

}
