package com.jsp.spi_kart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spi_kart.dao.ItemsDao;
import com.jsp.spi_kart.dto.ItemsDto;

@Service
public class ItemsService {
	
@Autowired
ItemsDao itemdao;


public void saveItem(ItemsDto dto)
{
	itemdao.saveItem(dto);
}

public void deleteItemById(int itemId) {
	itemdao.deleteItemById(itemId);
}

public void deleteAllItems()
{
	itemdao.deleteAllItems();
}

public ItemsDto fetchItemById(int itemid)
{
 ItemsDto dto=itemdao.fetchItemById(itemid);
 return dto;
}


public List<ItemsDto> fetchAllItems() {
	 List<ItemsDto> items=itemdao.fetchAllItems(); 
	 return items;
	}

public void updateItem(ItemsDto dto)
{
	itemdao.updateItem(dto);
}
}
