package com.jsp.spi_kart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spi_kart.dto.AddressDto;

public interface AddressRepository extends JpaRepository<AddressDto, Long>{

}
