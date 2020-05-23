package com.ailibaba.cloud.nacosconfig.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fujie.feng
 * @Date 2020-05-18
 */
@RestController
@RefreshScope // nacos动态刷新
@RequestMapping("/config")
public class TestConfigController {

	@Value("${test.info}")
	private String info;

	@GetMapping("/get")
	public String getConfig() {
		return "获取nacos配置信息，info=" + info;
	}

}
