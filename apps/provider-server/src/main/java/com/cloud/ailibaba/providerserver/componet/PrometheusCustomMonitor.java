package com.cloud.ailibaba.providerserver.componet;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fujie.feng
 * @Date 2020-07-09
 */
@Component
public class PrometheusCustomMonitor {

	private Counter requestErrorCount;

	private Counter orderCount;

	private DistributionSummary amountSum;

	private final MeterRegistry registry;

	@Autowired
	public PrometheusCustomMonitor(MeterRegistry registry) {
		this.registry = registry;
	}

	@PostConstruct
	private void init() {
		requestErrorCount = registry.counter("request_error_total", "status", "error");
		orderCount = registry.counter("order_request_count", "order", "test-svc");
		amountSum = registry.summary("order_amount_sum", "orderAmount", "test-svc");
	}

	public Counter getRequestErrorCount() {
		return requestErrorCount;
	}

	public Counter getOrderCount() {
		return orderCount;
	}

	public DistributionSummary getAmountSum() {
		return amountSum;
	}
}
