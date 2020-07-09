package com.cloud.ailibaba.nacosserver.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fujie.feng
 * @Date 2020-07-09
 */
@Configuration
public class MeterRegistryConfig {

	@Value("{spring.application.name}")
	private String applicationName;

	@Bean
	MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
		return registry -> registry.config().commonTags("application", applicationName);
	}
}
