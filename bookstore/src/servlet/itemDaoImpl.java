package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.item;
import database.ConnectionManager;

public class itemDaoImpl {
	private Connection connection;
	private PreparedStatement itemQuery;
	private ResultSet result;
	
	//返回item列表
	public List getItem(){
		List itemList=new ArrayList();
		try{
			connection=ConnectionManager.getConnection();
			 itemQuery=connection.prepareStatement("SELECT item_id,item_name,item_number,"
			 		+ "item_level,item_price FROM item ORDER BY item_id");
			 ResultSet results=itemQuery.executeQuery();
			 
			 while(results.next()){
				 item items=new item();
				 items.setItem_id(results.getLong("item_id"));
				 items.setItem_name(results.getString("item_name"));
				 items.setItem_level(results.getFloat("item_level"));
				 items.setItem_number(results.getShort("item_number"));
				 items.setItem_price(results.getFloat("item_price"));
				 itemList.add(items);
			 }
			 
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		finally{
			ConnectionManager.closeResultSet(result);
			ConnectionManager.closeStatement(itemQuery);
			ConnectionManager.closeConnection(connection);
		}
	
	return itemList;
	}
}
