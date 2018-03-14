package cn.dean.spring.pojo;

import java.util.ArrayList;
import java.util.List;

public class QueryVo {
	Items items = new Items();

	List<Items> itemList = new ArrayList<Items>();
	
	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
}
