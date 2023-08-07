package com.jsp.spi_kart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spi_kart.dao.MerchantDao;
import com.jsp.spi_kart.dto.MerchantDto;
import com.jsp.spi_kart.dto.ProductDto;

@Service
public class MerchantService {
	@Autowired
	MerchantDao dao;

	@Autowired
	ProductService productService;

	public void createMerchant(MerchantDto dto) {
		dao.createMerchant(dto);
	}

	
	public MerchantDto fetchMerchantById(int merchantid)
	{
	   MerchantDto	md= dao.findMerchantById(merchantid);
	   
	   return md;
	}
	
	public void deleteMerchantById(int merchantid)
	{
		dao.deleteMerchantById(merchantid);
	}
	
	public void updateMerchantById(MerchantDto dto)
    {
		dao.updateMerchantById(dto);
    }
	
	public ProductDto findById(int merchantid, ProductDto product) {

		MerchantDto md = dao.findMerchantById(merchantid);// step1
		List<ProductDto> products = md.getProducts();
		products.add(product);

		product.setMerchantDto(md);// add merchant to product
		productService.saveProducts(product);

		md.setProducts(products);// add product to merchant
		dao.createMerchant(md);

		return null;
	}

	public List<ProductDto> viewProductById(int merchantid) {
		MerchantDto md = dao.findMerchantById(merchantid);
		List<ProductDto> products = md.getProducts();

		return products;
	}

	public List<MerchantDto> validateMerchant(String email, long password) {
		List<MerchantDto> md = dao.validateMerchant(email, password);
		return md;
	}

}
