package com.jsp.spi_kart.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.spi_kart.dto.ProductDto;
import com.jsp.spi_kart.repository.MerchantRepository;
import com.jsp.spi_kart.repository.ProductRepository;

@Component
public class ProductDao {
	@Autowired
	ProductRepository productRepository;
	MerchantRepository merchantRepository;
	
	public ProductDto saveProducts(ProductDto dto) {
	      productRepository.save(dto);
	      return dto;
	}
	
	
	public ProductDto fetchProductsById(int pid)
	{
	Optional<ProductDto> dto=productRepository.findById(pid);
	return dto.get();
	}
	
	public List<ProductDto> fetchProducts()
	{
	 List<ProductDto> dtos=productRepository.findAll();
	 
	 return dtos;
	}
	
	public void deleteProductById(int pid)
	{
		productRepository.deleteById(pid);
	}
	
	public void deleteProducts()
	{
		productRepository.deleteAll();
	}
	
	public void editProducts(ProductDto dto)
	{
		productRepository.save(dto);
	}
}
