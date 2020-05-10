package com.cloud.ailibaba.providerserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * provider 测试类
 * @author fujie.feng
 * @Date 2020-05-05
 */
@RestController
@RequestMapping("/provider")
public class TestProviderController {

	@Value("${server.port}")
	private String port;

	@RequestMapping("/test/{name}")
	public String test(@PathVariable("name") String name) {
		return "nacos server -  provider - server : port : " + port + ">>> operator:" + name + "向前冲";
	}
}