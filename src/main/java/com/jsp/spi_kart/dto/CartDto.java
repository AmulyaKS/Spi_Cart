package com.jsp.spi_kart.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Component
@Entity
public class CartDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// items(OneToMany)
	@OneToOne
	private CustomerDto customerDto;
	
	@OneToMany
	 private List<ItemsDto> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public List<ItemsDto> getItems() {
		return items;
	}

	public void setItems(List<ItemsDto> items) {
		this.items = items;
	}

//	@Override
//	public String toString() {
//		return "CartDto [id=" + id + ", customerDto=" + customerDto + ", items=" + items + "]";
//	}
	
	
	
}
