package com.jsp.spi_kart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spi_kart.dao.ProductDao;
import com.jsp.spi_kart.dto.ProductDto;

@Service
public class ProductService {
	@Autowired
	ProductDao dao;
	
	public ProductDto saveProducts(ProductDto dto) {
	      dao.saveProducts(dto);
	      return dto;
	}
	
	public List<ProductDto> fetchProducts()
	{
	 List<ProductDto> dtos=dao.fetchProducts();
	 
	 return dtos;
	}
	
	public ProductDto fetchProductsById(int pid)
	{
	 ProductDto dto=dao.fetchProductsById(pid);
	 return dto;
	
	}
	
	public void deleteProductById(int pid)
	{
		dao.deleteProductById(pid);
	}
	
	public void deleteProducts()
	{
		dao.deleteProducts();
	}
	
	public void editProducts(ProductDto dto)
	{
		dao.editProducts(dto);
	}
}
