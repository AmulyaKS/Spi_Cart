package com.jsp.spi_kart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.spi_kart.dto.MerchantDto;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantDto, Integer>{

	@Query("select data from MerchantDto data where email=:email and password=:password")
	List<MerchantDto> validate(String email,long password);
}
