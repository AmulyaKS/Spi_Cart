package com.jsp.spi_kart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spi_kart.dto.AdminDto;
import com.jsp.spi_kart.dto.CustomerDto;
import com.jsp.spi_kart.dto.MerchantDto;
import com.jsp.spi_kart.service.AdminService;
import com.jsp.spi_kart.service.CustomerService;
import com.jsp.spi_kart.service.MerchantService;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	MerchantService merchantService;
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/signup")
	public  void createAdmin(@RequestBody AdminDto adminDto) {
      adminService.createAdmin(adminDto);
	}

	@PostMapping("/signin")
	public void adminLogin() {

	}
	@GetMapping("/viewmerchants/{merchantid}")
	public void fetchMerchantById(@PathVariable int merchantid)
	{
	MerchantDto md=merchantService.fetchMerchantById(merchantid);
	
	System.out.println(md);
	}
	
	@GetMapping("/viewcustomers/{customerid}")
	public CustomerDto fetchCustomerById(@PathVariable int customerid)
	{
	CustomerDto cd=customerService.fetchCustomerById(customerid);
	return cd;
	}
	
	@DeleteMapping("/removemerchants/{merchantid}")
	public void deleteMerchantById(@PathVariable int merchantid)
	{
		merchantService.deleteMerchantById(merchantid);
	}
	
	@DeleteMapping("/removecustomers/{customerid}")
	public void deleteCustomerById(@PathVariable int customerid)
	{
		customerService.deleteCustomerById(customerid);
	}

}
