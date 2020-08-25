package com.cloud.ailibaba.providerserver.metrics;

import java.util.concurrent.Callable;
import java.util.function.ToDoubleFunction;

/**
 * @author fujie.feng
 * @Date 2020-07-09
 */
public class SpringMetricGuage {

	public static final ToDoubleFunction<Callable<Double>> metricFunc = doubleCallable -> {
		try {
			return doubleCallable.call();
		} catch (Exception e) {
			e.printStackTrace(); // NOSONAR
			return 0L;
		}
	};
}
