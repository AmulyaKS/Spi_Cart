package com.jsp.spi_kart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spi_kart.dao.AdminDao;
import com.jsp.spi_kart.dto.AdminDto;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	
	public void createAdmin(AdminDto dto) {
	  adminDao.createAdmin(dto);
	}
}
