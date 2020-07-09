package com.cloud.ailibaba.providerserver.exception;

import com.cloud.ailibaba.providerserver.componet.PrometheusCustomMonitor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author fujie.feng
 * @Date 2020-07-09
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@Resource
	private PrometheusCustomMonitor monitor;

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public String handler(Exception e) {
		monitor.getRequestErrorCount().increment();
		return "error, message:" + e.getMessage();
	}
}
