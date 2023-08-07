package com.jsp.spi_kart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.spi_kart.dto.AdminDto;
import com.jsp.spi_kart.repository.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	AdminRepository adminRepository;

	public void createAdmin(AdminDto adminDto) {
	      adminRepository.save(adminDto);
	}
	
}
