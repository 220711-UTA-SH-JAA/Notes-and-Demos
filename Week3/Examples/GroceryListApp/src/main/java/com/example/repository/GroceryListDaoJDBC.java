package com.example.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.example.models.Customer;
import com.example.models.GroceryList;
import com.example.models.Item;
import com.example.models.ItemType;
import com.example.utils.JDBCConnectionUtil;

public class GroceryListDaoJDBC implements GroceryListDao{
	
	/* Callable statements
	 * - an interface used to execute stored procedure and function from your database
	 * - To get access to a callable you do the same thing as the statements and get it from the connection
	 * - You must prepare the call where you pass in any parameters
	 * - You can access the result the same way if you are calling a function
	 * - The way call the stored function/procedure will differ depending on if it is a function or procedure
	 */
	
	JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();

	@Override
	public void createList(GroceryList gl) {

		try {
			Connection connection = conUtil.getConnectionThroughENV();
			
			//Similar to creating our queries, but now we are using call to call the procedure
			String sql = "call create_list(?,?)";
			
			CallableStatement callable = connection.prepareCall(sql);
			
			//Set the parameters
			callable.setString(1, gl.getListName());
			callable.setInt(2, gl.getCustomer().getCustomerId());
			
			//Since this won't be returning anything, we will just call execute
			callable.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void createItemReference(GroceryList gl, Item i) {

		try {
			
			Connection connection = conUtil.getConnectionThroughENV();
			
			String sql = "call add_item_to_list(?,?)";
			
			CallableStatement callable = connection.prepareCall(sql);
			
			callable.setInt(1, gl.getListId());
			callable.setInt(2, i.getItemId());
			
			callable.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteItemReference(GroceryList gl, Item i) {
		try {
			
			Connection connection = conUtil.getConnectionThroughENV();
			
			String sql = "call delete_item_from_list(?,?)";
			
			CallableStatement callable = connection.prepareCall(sql);
			
			callable.setInt(1, gl.getListId());
			callable.setInt(2, i.getItemId());
			
			callable.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public GroceryList getListByName(String name) {

		GroceryList gl = null;
		
		Connection connection = conUtil.getConnectionThroughENV();
		
		try {
			
			//We have to turn off autocommit so that we can access the result set
			//REMEMBER TO RENABLE THIS AT THE END OF THE METHOD
			//IF YOU DON'T YOU WILL PROBABLY DEBUG AN ISSUE FOR HOURS
			connection.setAutoCommit(false);
			
			//How we call a function in JAVA
			String sql = "{?=call get_list_by_name(?)}";
			
			CallableStatement callable = connection.prepareCall(sql);
			
			//The function returns a ref cursor, so need to turn register an out parameter for our function
			callable.registerOutParameter(1, Types.OTHER);
			
			callable.setString(2, name);
			
			callable.execute();
			
			ResultSet results = (ResultSet) callable.getObject(1);
			
			int index = 0;
			
			//1	Ethans Kroger List	1	Milk	3	2.99	1	Ethan	McGill	emcgill	ethan@email.com
			while(results.next()) {
				if(index == 0) {
					gl = new GroceryList();
					gl.setListId(results.getInt(1));
					gl.setListName(results.getString(2));
					Customer c = new Customer();
					c.setCustomerId(results.getInt(7));
					c.setFirstName(results.getString(8));
					c.setLastName(results.getString(9));
					c.setUsername(results.getString(10));
					c.setEmail(results.getString(11));
					gl.setCustomer(c);
					index++;
				}
				
				List<Item> items = gl.getItems();
				ItemType type;
				switch(results.getInt(5)) {
					case 1:
						type = ItemType.MEAT;
						break;
					case 2:
						type = ItemType.PRODUCE;
						break;
					case 3:
						type = ItemType.BEVERAGE;
						break;
					case 4:
						type = ItemType.SNACK;
						break;
					case 5:
						type = ItemType.SAUCE;
						break;
					case 6:
						type = ItemType.HOUSEHOLD;
						break;
					default:
						type = ItemType.OTHER;
						break;
				}
				Item i = new Item(results.getInt(3), results.getString(4), type, results.getDouble(6));
				items.add(i);
				gl.setItems(items);
				
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return gl;
	}
	
}
