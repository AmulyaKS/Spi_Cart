package com.jsp.spi_kart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.jsp.spi_kart.dao.CustomerDao;
import com.jsp.spi_kart.dto.CartDto;
import com.jsp.spi_kart.dto.CustomerDto;
import com.jsp.spi_kart.dto.ItemsDto;
import com.jsp.spi_kart.dto.ProductDto;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	ProductService productService;

	@Autowired
	CartService cartService;

	@Autowired
	ItemsService itemsService;

	public void createCustomer(CustomerDto customerDto) {
		customerDao.createCustomer(customerDto);
	}

	public CustomerDto fetchCustomerById(int customerid) {
		CustomerDto cd = customerDao.fetchCustomerById(customerid);
		return cd;
	}

	public void deleteCustomerById(int customerid) {
		customerDao.deleteCustomerById(customerid);
	}

	public void updateCustomer(CustomerDto customerDto) {
		customerDao.updateCustomer(customerDto);
	}

	public void addProductToCart(int productid, int Quantity, int customerid) {
		ProductDto dto = productService.fetchProductsById(productid);
		CustomerDto cd = customerDao.fetchCustomerById(customerid);

		String pname = dto.getName();
		double price = dto.getPrice();

		CartDto cartdto = cd.getCart();

		if (cartdto == null) {
			cartdto = new CartDto();
		}

		List<ItemsDto> items = cartdto.getItems();

		if (items == null) {
			items = new ArrayList<ItemsDto>();
		}

		if (items.isEmpty()) {
			ItemsDto item = new ItemsDto();
			item.setName(pname);
			item.setPrice(Quantity * price);
			item.setQuantity(Quantity);

//    	    itemsService.saveItem(item);

			dto.setStock(dto.getStock() - Quantity);

			items.add(item);
		} else {
			boolean flag = false;
			for (ItemsDto itm : items) {
				if (itm.getName().equals(pname)) {
					itm.setQuantity(itm.getQuantity() + Quantity);
					itm.setPrice(itm.getPrice() + (Quantity * price));
					dto.setStock(dto.getStock() - Quantity);

					itemsService.saveItem(itm);

					flag = false;
					break;
				} else {
					flag = true;
				}
			}

			if (flag) {
				ItemsDto item = new ItemsDto();
				item.setName(pname);
				item.setPrice(Quantity * price);
				item.setQuantity(Quantity);

				itemsService.saveItem(item);
				dto.setStock(dto.getStock() - Quantity);

				items.add(item);
			}
		}

		cartdto.setItems(items);
		cartdto.setCustomerDto(cd); // you should check
		cartService.saveCart(cartdto);

		cd.setCart(cartdto);
		customerDao.updateCustomer(cd);

	}

	public void deleteProductFromCart(@PathVariable int itemid,@PathVariable int cartid) {
		CartDto cd=cartService.fetchCartById(cartid);
		ItemsDto item=itemsService.fetchItemById(itemid);
		List<ItemsDto> list=cd.getItems();
		for(ItemsDto itd:list)
		{
			if(itd.getName().equals(item.getName()))
			{
				list.remove(itd);
				itemsService.deleteItemById(itemid);
				break;
			}
		}
	}
	
	public List<ItemsDto> viewItemsFromCart(int cartid)
	{
	    CartDto cd=cartService.fetchCartById(cartid);
	    List<ItemsDto> items=cd.getItems();
	    return items;
	}
}
