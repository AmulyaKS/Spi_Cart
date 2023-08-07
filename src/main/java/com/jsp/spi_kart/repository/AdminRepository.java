package com.jsp.spi_kart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jsp.spi_kart.dto.AdminDto;

@Component
public interface AdminRepository extends JpaRepository<AdminDto, Integer>{

}
