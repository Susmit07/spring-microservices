package com.sapient.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.sapient.microservices.currencyconversionservice")
//Registering with the Eureka naming server.
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	// http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/1000
	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
	
	// It will assign a id to the request, and we can use that ID to trace that particular request across multiple components
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
