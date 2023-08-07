package com.jsp.spi_kart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spi_kart.dto.WishListDto;

public interface WishListRepository extends JpaRepository<WishListDto,Integer>{

}
