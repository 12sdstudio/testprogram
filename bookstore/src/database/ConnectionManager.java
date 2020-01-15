package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager {
	private static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL="jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
	private static final String DATABASE_USER="root";
	private static final String DATABASE_PASSWORD="603001";
	
	public static Connection getConnection(){
		Connection dbConnection=null;
		try{
			Class.forName(DRIVER_CLASS);
			dbConnection=DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dbConnection;
	}
	
	public static void closeConnection(Connection connection){
		if(connection!=null){
			try{
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(Statement statement){
		if(statement!=null){
			try{
				statement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void closeResultSet(ResultSet resultset){
		if(resultset!=null){
			try{
				resultset.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
