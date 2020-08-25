package com.cloud.ailibaba.providerserver.metrics;

import java.util.SortedMap;
import java.util.concurrent.Callable;

/**
 * @author fujie.feng
 * @Date 2020-07-09
 */
public interface MetricsClient {

	/**
	 * 累加器
	 * @param metricsName 埋点名
	 * @param description 埋点描述
	 * @param tagMap 定义埋点的相关标签
	 * @return
	 */
	MetricCounter counter(String metricsName, String description, SortedMap<String, String> tagMap);


	/**
	 * 计时器
	 * @param metricsName
	 * @param descrtption
	 * @param tagMap
	 * @return
	 */
	MetricTimer timer(String metricsName, String descrtption, SortedMap<String, String> tagMap);

	/**
	 * 瞬时值记录
	 * @param metricsName
	 * @param description
	 * @param tagMap
	 * @param callable 封装如何计算值的逻辑
	 */
	void gauge(String metricsName, String description, SortedMap<String, String> tagMap, Callable<Double> callable);
}
