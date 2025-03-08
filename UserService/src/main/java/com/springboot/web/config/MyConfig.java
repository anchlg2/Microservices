package com.springboot.web.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class MyConfig {
	@Bean
	@LoadBalanced  //this annoation is added so that we can use service name directly in place of port and host in Microservice communication
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
