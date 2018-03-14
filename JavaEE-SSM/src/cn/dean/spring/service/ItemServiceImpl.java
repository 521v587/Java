package cn.dean.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dean.spring.dao.ItemsMapper;
import cn.dean.spring.pojo.Items;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	public List<Items> selectItemsList(){
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	
	public Items selectItemsById(Integer id){
		return itemsMapper.selectByPrimaryKey(id);
	}
	
	//更新
	public void updateItemsById(Items item){
		item.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(item);
	}
}
