package com.sapient.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.sapient.microservices.currencyexchangeservice.dao.ExchangeServiceRepository;

@RestController
public class CurrencyExchangeServiceController {
	
	@Autowired 
	private Environment environment;
	
	@Autowired
	ExchangeServiceRepository repository;
	
	// localhost:8000/h2-console
	// Using in memory H2 DB please keep in mind the JDBC URL should be jdbc:h2:mem:testdb
	// localhost:8000/currency-exchange/from/USD/to/INR
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		if(exchangeValue != null)
			exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
