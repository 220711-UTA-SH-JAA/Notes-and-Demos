package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="lists")
public class GroceryList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="list_id")
	private Integer listId;
	
	@Column(name="list_name")
	private String listName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="list_item_junction",
			joinColumns = {@JoinColumn(name="list_id")},
			inverseJoinColumns = {@JoinColumn(name="item_id")}
	)
	private List<Item> items;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	public GroceryList() {
		super();
		items  = new ArrayList<>();
	}

	public GroceryList(Integer listId, String listName, List<Item> items, User user) {
		super();
		this.listId = listId;
		this.listName = listName;
		this.items = items;
		this.user = user;
	}

	public Integer getListId() {
		return listId;
	}

	public void setListId(Integer listId) {
		this.listId = listId;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "GroceryList [listId=" + listId + ", listName=" + listName + ", items=" + items + ", user=" + user.getUsername() + "]";
	}
}
