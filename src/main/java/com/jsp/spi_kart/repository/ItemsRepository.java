package com.jsp.spi_kart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.spi_kart.dto.ItemsDto;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsDto, Integer>{

}
