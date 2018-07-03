package com.sapient.microservices.currencyconversionservice.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.sapient.microservices.currencyconversionservice.bean.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
// Now API gateway layer is being introduced between currency-exchange-service 
// and currency-conversion-service via Zuul
@FeignClient(name="netflix-zuul-api-gateway-server")
// We will be invoking multiple instances by distributing the currency exchange service.
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	// Now define a method to talk to currency-exchange-service
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	// Changing the URL to connect to the currency-exchange-service via the API gateway 
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	// (value = "from") --> Solved -- Caused by: java.lang.IllegalStateException: 
	//PathVariable annotation was empty on param 0.
	public CurrencyConversionBean retrieveExchangeValue
	(@PathVariable (value = "from") String from, @PathVariable (value = "to") String to);
}
