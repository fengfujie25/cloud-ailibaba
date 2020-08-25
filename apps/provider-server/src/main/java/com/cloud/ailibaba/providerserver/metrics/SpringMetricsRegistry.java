package com.cloud.ailibaba.providerserver.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;

/**
 * @author fujie.feng
 * @Date 2020-07-09
 */
@Slf4j
public class SpringMetricsRegistry implements MeterBinder {

	private MeterRegistry registry;

	@PreDestroy
	public void destory() {
		if (registry != null && !registry.isClosed()) {
			registry.close();
		}
	}


	@Override
	public void bindTo(MeterRegistry meterRegistry) {
		if (this.registry == null) {
			this.registry = meterRegistry;
			log.info("MeterRegistry is set ...");
		}
	}

	//public void registerGauge(Srping)

}
