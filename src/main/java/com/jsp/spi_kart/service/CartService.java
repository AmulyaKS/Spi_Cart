package com.jsp.spi_kart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spi_kart.dao.CartDao;
import com.jsp.spi_kart.dto.CartDto;

@Service
public class CartService {
	
	@Autowired
	CartDao cartDao;
	
	public void saveCart(CartDto cartDto)
	{
		cartDao.saveCart(cartDto);
	}
	
	public CartDto fetchCartById(int cartid)
	{
	CartDto cd=cartDao.fetchCartById(cartid);
	return cd;
		
	}
}
