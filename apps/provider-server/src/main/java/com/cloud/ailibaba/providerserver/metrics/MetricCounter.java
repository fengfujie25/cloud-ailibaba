package com.cloud.ailibaba.providerserver.metrics;

/**
 * 累加计数器
 * @author fujie.feng
 * @Date 2020-07-09
 */
public interface MetricCounter {

	/**
	 * 累加1
	 */
	void increment();

	/**
	 * 累加num
	 * @param num
	 */
	void incrementBy(long num);
}
