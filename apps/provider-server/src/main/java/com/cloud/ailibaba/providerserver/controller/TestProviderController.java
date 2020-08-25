package com.cloud.ailibaba.providerserver.controller;


import com.cloud.ailibaba.providerserver.annotation.Log;
import com.cloud.ailibaba.providerserver.componet.PrometheusCustomMonitor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

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

	@Resource
	private PrometheusCustomMonitor monitor;

	@Log()
	@RequestMapping("/test/{name}")
	public String test(@PathVariable("name") String name) {
//		try {
//			int a = 1 / 0;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return "nacos server -  provider - server : port : " + port + ">>> operator:" + name + "向前冲";
	}

	@RequestMapping("/order")
	public String order(@RequestParam(defaultValue = "0") String flag) throws Exception {
		monitor.getOrderCount().increment();
		monitor.timer(0);
		if ("1".equals(flag)) {
			throw new Exception("Exception");
		}

		Random random = new Random();
		int amout = random.nextInt(100);
		monitor.getAmountSum().record(amout);
		monitor.guage(amout);
		monitor.timer(amout);
		return "success, amount=" + amout;
	}
}
