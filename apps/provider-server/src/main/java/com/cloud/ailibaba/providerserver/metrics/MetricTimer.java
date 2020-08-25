package com.cloud.ailibaba.providerserver.metrics;

import java.util.concurrent.TimeUnit;

/**
 * 计时器
 * @author fujie.feng
 * @Date 2020-07-09
 */
public interface MetricTimer {

	/**
	 * 记录消耗时间
	 * @param millis
	 */
	void record(long millis);

	/**
	 * 记录消耗时间，指定单位
	 * @param time
	 * @param unit
	 */
	void record(long time, TimeUnit unit);
}
