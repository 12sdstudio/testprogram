package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Title;
import bean.item;

public class TitleDaoImpl implements TitleDao{
	private Connection connection;
	private PreparedStatement titlesQuery;
	private ResultSet results;
	
	public List getTitles(){
		List titlesList=new ArrayList();
		try{
			connection=ConnectionManager.getConnection();
			titlesQuery=connection.prepareStatement("SELECT isbn,title,editionNumber,"
			 		+ "copyright,publisherID,imageFile,price FROM titles ORDER BY title");
			 ResultSet results=titlesQuery.executeQuery();
			 
			 while(results.next()){
				 Title book=new Title();
				 book.setIsbn(results.getString("isbn"));
			     book.setTitle(results.getString("title"));
			     book.setEditionNumber(results.getInt("editionNumber"));
			     book.setCopyright(results.getString("copyright"));
			     book.setImageFile(results.getString("publisherID"));
			     book.setImageFile(results.getString("imageFile"));
			     book.setPrice(results.getFloat("price"));
				 titlesList.add(book);
			 }
			 
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		finally{
			ConnectionManager.closeResultSet(results);
			ConnectionManager.closeStatement(titlesQuery);
			ConnectionManager.closeConnection(connection);
		}
	
	return titlesList;
	}
	
	public int add(Title title){
		int result=0;
		try{
			connection=ConnectionManager.getConnection();
			String sql="insert into titles(isbn,title,editionNumber,";
			sql+="copyright,publisherID,imageFile,price)values(?,?,?,?,?,?,?)";
			titlesQuery=connection.prepareStatement(sql);
			titlesQuery.setString(1,title.getIsbn());
			titlesQuery.setString(2,title.getTitle());
			titlesQuery.setInt(3,title.getEditionNumber());
			titlesQuery.setString(4,title.getCopyright());
			titlesQuery.setInt(5,title.getPublisherId());
			titlesQuery.setString(6,title.getImageFile());
			titlesQuery.setFloat(7,title.getPrice());
			result=titlesQuery.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			ConnectionManager.closeResultSet(results);
			ConnectionManager.closeStatement(titlesQuery);
			ConnectionManager.closeConnection(connection);
		}
		return result;
	}
	
	public int delete(String isbn){
	   int result=0;
	   try{
		   connection=ConnectionManager.getConnection();
		   String sql="delete from titles where isbn='"+isbn+"'";
		   titlesQuery=connection.prepareStatement(sql);
		   result=titlesQuery.executeUpdate();
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		   ConnectionManager.closeResultSet(results);
		   ConnectionManager.closeStatement(titlesQuery);
		   ConnectionManager.closeConnection(connection);
	   }
	   return result;
	}
	
	public int update(Title title){
		int result=0;
		try{
			connection=ConnectionManager.getConnection();
			String sql="update titles set title=?,editionNumber=?,";
			sql+="copyright=?,publisherID=?imageFile=?,price=? where isbn=?";
			titlesQuery=connection.prepareStatement(sql);
			titlesQuery.setString(1,title.getIsbn());
			titlesQuery.setString(2,title.getTitle());
			titlesQuery.setInt(3,title.getEditionNumber());
			titlesQuery.setString(4,title.getCopyright());
			titlesQuery.setInt(5,title.getPublisherId());
			titlesQuery.setString(6,title.getImageFile());
			titlesQuery.setFloat(7,title.getPrice());
			result=titlesQuery.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectionManager.closeResultSet(results);
		    ConnectionManager.closeStatement(titlesQuery);
			ConnectionManager.closeConnection(connection);
		}
		return result;
	}
	
	public Title findByIsbn(String isbn){
		Title book=null;
		try{
			connection=ConnectionManager.getConnection();
			String sql="SELECT *FROM titles where isbn='"+isbn+"'";
			titlesQuery=connection.prepareStatement(sql);
			results=titlesQuery.executeQuery();
			if(results.next()){
				book=new Title();
				book.setIsbn(results.getString("isbn"));
				book.setTitle(results.getString("title"));
				book.setEditionNumber(results.getInt("editionNumber"));
				book.setPublisherId(results.getInt("pubsherID"));
				book.setImageFile(results.getString("imageFile"));
				book.setPrice(results.getFloat("price"));
			}
		}catch(Exception e){
				e.printStackTrace();
		}finally{
			 ConnectionManager.closeResultSet(results);
			 ConnectionManager.closeStatement(titlesQuery);
			 ConnectionManager.closeConnection(connection);
		}
		return book;
	}
	
}
