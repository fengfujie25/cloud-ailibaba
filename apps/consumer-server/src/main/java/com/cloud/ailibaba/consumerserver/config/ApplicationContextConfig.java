package com.cloud.ailibaba.consumerserver.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置RestTemplate bean
 * @author fujie.feng
 * @Date 2020-05-09
 */
@Configuration
public class ApplicationContextConfig {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
