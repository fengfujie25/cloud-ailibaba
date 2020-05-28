package com.ailibaba.cloud.sentinelserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fujie.feng
 * @Date 2020-05-25
 */
@RestController
//@RequestMapping("/sentinel")
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "success";
	}

	@GetMapping("/app")
	public String testApp() {
		return "app";
	}
	
}
