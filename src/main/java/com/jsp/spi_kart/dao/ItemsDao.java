package com.jsp.spi_kart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.spi_kart.dto.ItemsDto;
import com.jsp.spi_kart.repository.ItemsRepository;

@Component
public class ItemsDao {
	@Autowired 
	ItemsRepository itemsRepository;
	
public void saveItem(ItemsDto dto)
{
	itemsRepository.save(dto);
}

public void deleteItemById(int itemId) {
	itemsRepository.deleteById(itemId);
}

public void deleteAllItems()
{
	itemsRepository.deleteAll();
}

public ItemsDto fetchItemById(int itemid)
{
	Optional<ItemsDto>  item= itemsRepository.findById(itemid);
	if(item.isPresent())
	{
		return item.get();
	}
	else
	{
		return null;
	}
}

public List<ItemsDto> fetchAllItems() {
 List<ItemsDto> items=itemsRepository.findAll(); 
 return items;
}

public void updateItem(ItemsDto dto)
{
	itemsRepository.save(dto);
}
}
