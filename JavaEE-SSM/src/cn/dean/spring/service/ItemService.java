package cn.dean.spring.service;

import java.util.List;

import cn.dean.spring.pojo.Items;

public interface ItemService {
	public List<Items> selectItemsList();
	public Items selectItemsById(Integer id);
	//更新
	public void updateItemsById(Items item);
}
