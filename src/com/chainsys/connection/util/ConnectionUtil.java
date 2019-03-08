package com.chainsys.connection.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getconnection(){
		Connection connection=null;
		
	
       try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
		connection = DriverManager.getConnection(url, "hr", "hr");
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	}
		
 
		 /**
		 * @param conn
		 * @param pstmt
		 * @param rs
		 */
		public static void close(Connection conn,PreparedStatement pstmt, ResultSet rs){
			    try{
			        if(rs != null){
			            rs.close();
			        }
			            if(pstmt != null){
			                pstmt.close();
			            }
			                if(conn != null){
			                    conn.close();}
			                }catch(SQLException e){
			        
			        }
			    
    }  
		  
}