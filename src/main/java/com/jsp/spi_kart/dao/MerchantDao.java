package com.jsp.spi_kart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.spi_kart.dto.MerchantDto;
import com.jsp.spi_kart.repository.MerchantRepository;

@Component
public class MerchantDao {
	@Autowired
	MerchantRepository merchantRepository;

	public void createMerchant(MerchantDto dto) {
		merchantRepository.save(dto);
	}

	public MerchantDto findMerchantById(int merchantid) {
		Optional<MerchantDto> om = merchantRepository.findById(merchantid);
		if (om.isPresent()) {
			return om.get();
		} else
			return null;
	}
	
	public void deleteMerchantById(int merchantid)
	{
		merchantRepository.deleteById(merchantid);
	}
   
	
	public void updateMerchantById(MerchantDto dto)
    {
		merchantRepository.save(dto);
    }
	
	public List<MerchantDto> validateMerchant(String email, long password) {
		List<MerchantDto> md = merchantRepository.validate(email, password);
		return md;
	}
	
	public List<MerchantDto> fetchAllMerchants() {
	List<MerchantDto>	dtos=merchantRepository.findAll();
	
	return dtos;
	}

}
