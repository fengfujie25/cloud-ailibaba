package com.cloud.ailibaba.nacosserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosServerApplication.class, args);
	}

}
