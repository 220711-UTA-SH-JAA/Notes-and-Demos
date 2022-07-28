package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Item;
import com.example.models.ItemType;
import com.example.utils.JDBCConnectionUtil;

public class ItemDaoJDBC implements ItemDao{

	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();
	
	@Override
	public void createItem(Item i) {
		//Using prepared statements
		try {
			Connection connection = conUtil.getConnectionThroughENV();
			
			String sql = "INSERT INTO item(item_name, item_type_fk, item_price) "
					+ "values (?,?,?)";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setString(1, i.getItemName());
			prepared.setInt(2, (i.getItemType().ordinal() + 1));
			prepared.setDouble(3, i.getPrice());
			
			prepared.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Item> getAllItems() {
		
		List<Item> items = new ArrayList<>();
		
		try {
			
			Connection connection = conUtil.getConnectionThroughENV();
			
			String sql = "SELECT * FROM item";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			ResultSet results = prepared.executeQuery();
			
			while(results.next()) {
				
				ItemType type;
				switch(results.getInt(3)) {
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
				items.add(new Item(results.getInt(1), results.getString(2), type, results.getDouble(4)));
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Item getItemByName(String itemName) {
		Item item = null;
		
		try {
			Connection connection = conUtil.getConnectionThroughENV();
			
			String sql = "SELECT * FROM item WHERE item_name = ?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			prepared.setString(1, itemName);
			
			ResultSet results = prepared.executeQuery();
			
			while(results.next()) {
				
				ItemType type;
				switch(results.getInt(3)) {
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
				
				item = new Item(results.getInt(1), results.getString(2), type, results.getDouble(4));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public void updateItem(Item i) {
		try {
			Connection connection = conUtil.getConnectionThroughENV();
			
			String sql = "UPDATE item SET item_name = ?, item_type_fk = ?, item_price = ? WHERE item_id = ?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setString(1, i.getItemName());
			prepared.setInt(2,  (i.getItemType().ordinal()+1));
			prepared.setDouble(3, i.getPrice());
			prepared.setInt(4, i.getItemId());
			
			prepared.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		try {
			Connection connection = conUtil.getConnectionThroughENV();
			
			String sql = "DELETE FROM item WHERE item_id = ?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			prepared.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
