package com.jsp.spi_kart.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.spi_kart.dto.CustomerDto;
import com.jsp.spi_kart.repository.CustomerRepository;

@Component
public class CustomerDao {
	@Autowired
	CustomerRepository customerRepository;
	
	public  void createCustomer(CustomerDto customerDto) {
		customerRepository.save(customerDto);
	}
	
	public CustomerDto fetchCustomerById(int customerid)
	{
	Optional<CustomerDto> cd=customerRepository.findById(customerid);
	if(cd.isPresent())
	{
		return cd.get();
	}else
	{
		return null;
	}
	}
	
	public void deleteCustomerById(int customerid)
	{
		customerRepository.deleteById(customerid);
	}
	
	public void updateCustomer(CustomerDto customerDto)
	{
		customerRepository.save(customerDto);
	}
	
	public List<CustomerDto> fetchAllCustomers()
	{
	List<CustomerDto> customerDtos=customerRepository.findAll();
	return customerDtos;
	}
}
