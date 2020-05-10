package com.cloud.ailibaba.consumerserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 消费者测试类
 * @author fujie.feng
 * @Date 2020-05-09
 */
@RestController
@RequestMapping("/consumer")
public class TestConsumerController {

	@Resource
	private RestTemplate restTemplate;

	@Value("${remote-service-url.provider-service-url}")
	private String serverUrl;

	@RequestMapping("/test/{name}")
	public String test(@PathVariable("name") String name) {
		String url = serverUrl + "/provider/test/" + name;
		return restTemplate.getForObject(url, String.class);
	}
}
