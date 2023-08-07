package com.jsp.spi_kart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spi_kart.dto.MerchantDto;
import com.jsp.spi_kart.dto.ProductDto;
import com.jsp.spi_kart.service.MerchantService;
import com.jsp.spi_kart.service.ProductService;

@RestController
@RequestMapping("/merchants")
public class MerchantController {
	@Autowired
	MerchantService merchantService;

	@Autowired
	ProductService productService;

	@PostMapping("/signup")
	public void createMerchant(@RequestBody MerchantDto dto) {
		merchantService.createMerchant(dto);
	}

	//@PostMapping("/signin/{merchantemail}/{merchantpassword}")
	//public  void merchantLogin(@PathVariable String merchantemail, @PathVariable long merchantpassword) {
	@PostMapping("/signin")
	public  void merchantLogin(@RequestBody MerchantDto dto) {	
	System.out.println(dto.getEmail() + " " + dto.getPassword());
	List<MerchantDto> md = merchantService.validateMerchant(dto.getEmail(), dto.getPassword());
	for(Object m:md)
	{
		System.out.println(m);
	}
		
	}
	
	@PutMapping("/updatemerchant")
    public void updateMerchantById(@RequestBody MerchantDto dto)
    {
    	merchantService.updateMerchantById(dto);
    }
	
	
	
	
	@PostMapping("/addproducts/{merchantid}")
	public void saveProducts(@RequestBody ProductDto product, @PathVariable int merchantid) {
		merchantService.findById(merchantid, product);

	}

	@GetMapping("/viewproductbymerchantid/{merchantid}")
	public void fetchProductsById(@PathVariable int merchantid) {
	 List<ProductDto> dtos=merchantService.viewProductById(merchantid);
	 for(ProductDto obj:dtos)
	 {
		 System.out.println(obj);
	 }
	 
	}	
	
	@GetMapping("/viewproducts")
	public void fetchProducts() {
		List<ProductDto> dtos = productService.fetchProducts();
		for (Object obj : dtos) {
			System.out.println(obj);
		}
	}

	@DeleteMapping("/removeproductbyid/{pid}")
	public void deleteProductById(@PathVariable int pid) {
		productService.deleteProductById(pid);
	}

	@DeleteMapping("/removeproducts")
	public void deleteProducts() {
		productService.deleteProducts();
	}

	@PutMapping("/updateproducts")
	public void editProducts(@RequestBody ProductDto dto) {
		productService.editProducts(dto);
	}
}
