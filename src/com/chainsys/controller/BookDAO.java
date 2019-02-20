package com.chainsys.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
	
	public static void addBook(int id , String name , int price) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "insert into book(id,name,price) values(?,?,?)";
		PreparedStatement preparedStatement = connection .prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setInt(3, price);
		int rows = preparedStatement.executeUpdate();
		System.out.println("rows inserted:" + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}
	public static void updateBook(int id,int price) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "update book set price =? where id =?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, price);
		preparedStatement.setInt(2, id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("rows updated:" + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public  static void  deleteBook(int id) throws SQLException, ClassNotFoundException {
		 Connection connection = ConnectionUtil.getconnection();
		String sql = "delete from book where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("rows deleted:" + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public  static ArrayList<Book> selectBook(String name) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "select id, name,price from book where name=? order by id asc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,name);
		ResultSet rset = preparedStatement.executeQuery();
		ArrayList<Book> arrayList=new ArrayList<Book>();
		
		while(rset.next()){
			Book book=new Book();
			book.id=rset.getInt("id");
			book.name=rset.getString("name");
			book.price=rset.getInt("price");
			arrayList.add(book);
			
		}
		
		ConnectionUtil.close(connection, preparedStatement,rset);
		return arrayList;
	}
	public static void userinsert(RegisterClass registerClass) throws SQLException{
		Connection connection = ConnectionUtil.getconnection();
		String sql = "insert into register(username,email,password,gender,id) values(?,?,?,?,userregister_id_seq.nextval)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,registerClass.username);
		preparedStatement.setString(2,registerClass.email);
		preparedStatement.setString(3,registerClass.password);
		preparedStatement.setString(4,registerClass.gender);
		@SuppressWarnings("unused")
		int rows = preparedStatement.executeUpdate();
		ConnectionUtil.close(connection, preparedStatement, null);
}
	public static  RegisterClass search(String email) throws SQLException{
		Connection connection = ConnectionUtil.getconnection();
		String sql = "select id from register where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,email);
		ResultSet rset = preparedStatement.executeQuery();
		RegisterClass registerclass=new RegisterClass();
		while(rset.next())
		{
			registerclass.id=rset.getInt("id");
		}
		
		return registerclass;		
}

	}

