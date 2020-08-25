package com.cloud.ailibaba.providerserver.componet;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

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

	public void guage(int num) {
		registry.gauge("test_order", Tags.of("site", "SiteA", "cab", "cab01"), new AtomicInteger(num));
	}

	public void timer(int num) {
		registry.timer("maomao", "timer", "long");
	}

	public void close() {
		registry.close();
	}
}
