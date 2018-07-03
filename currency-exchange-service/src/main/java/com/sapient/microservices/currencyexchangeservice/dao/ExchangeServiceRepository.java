package com.sapient.microservices.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.microservices.currencyexchangeservice.bean.ExchangeValue;

public interface ExchangeServiceRepository extends JpaRepository<ExchangeValue, Integer> {
	
	// Query on basis of from and to
	ExchangeValue findByFromAndTo(String from, String to);

}
