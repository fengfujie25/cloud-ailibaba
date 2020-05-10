package com.cloud.ailibaba.providerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author fengfujie
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderServerApplication.class, args);
	}

}
