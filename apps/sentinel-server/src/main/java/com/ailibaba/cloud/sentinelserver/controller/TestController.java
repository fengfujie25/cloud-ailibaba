package com.ailibaba.cloud.sentinelserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

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
