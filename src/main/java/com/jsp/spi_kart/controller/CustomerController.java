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

import com.jsp.spi_kart.dto.CustomerDto;
import com.jsp.spi_kart.dto.ItemsDto;
import com.jsp.spi_kart.dto.ProductDto;
import com.jsp.spi_kart.service.CustomerService;
import com.jsp.spi_kart.service.ProductService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/signup")
	public  void createCustomer(@RequestBody CustomerDto customerDto) {
		customerService.createCustomer(customerDto);
	}
	
	@PutMapping("/updatecustomer")
	public void updateCustomer(@RequestBody CustomerDto customerDto)
	{
		customerService.updateCustomer(customerDto);
	}
	
	
	
	
	
	
	@GetMapping("/viewproducts")
	public void  fetchProducts()
	{
	List<ProductDto> dtos=productService.fetchProducts();
	 for(ProductDto p:dtos)
	 {
		 System.out.println(p);
	 }
	 
	}
	
	
	@PostMapping("/addproducttocart/{productid}/{Quantity}/{customerid}")
	public void addProductToCart(@PathVariable int productid,@PathVariable int Quantity,@PathVariable int customerid)
	{
		customerService.addProductToCart(productid,Quantity,customerid);
	}
	
	@DeleteMapping("/deleteproductfromcart/{productid}/{cartid}")
	public void deleteProductFromCart(@PathVariable int itemid,@PathVariable int cartid) {
		customerService.deleteProductFromCart(itemid,cartid);
	}
	
	@GetMapping("/fetchitemsfromcart/{cartid}")
	public void viewItemsFromCart(int cartid)
	{
		List<ItemsDto> items=customerService.viewItemsFromCart(cartid);
		for (ItemsDto item : items) {
			System.out.println(item);
		}
	}
}
