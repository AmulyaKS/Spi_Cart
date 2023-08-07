package com.jsp.spi_kart.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.spi_kart.dto.CartDto;
import com.jsp.spi_kart.repository.CartRepository;

@Component
public class CartDao {
	@Autowired
	CartRepository cartRepository;
	
public void saveCart(CartDto cartDto)
{
	cartRepository.save(cartDto);
}

public CartDto fetchCartById(int cartid)
{
 Optional<CartDto> cd=cartRepository.findById(cartid);
 if(cd.isPresent())
 {
	 return cd.get();
 }
 else
 {
	 return null;
 }
}
}
