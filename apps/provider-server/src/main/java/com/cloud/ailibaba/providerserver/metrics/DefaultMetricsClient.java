package com.cloud.ailibaba.providerserver.metrics;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.SortedMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author fujie.feng
 * @Date 2020-07-09
 */
@Slf4j
public class DefaultMetricsClient implements MetricsClient {

	private Timer timer;

	private int period;

	private boolean mute;

	public DefaultMetricsClient() {
		this(10000);
	}

	public DefaultMetricsClient(int period) {
		this(period, false);
	}

	public DefaultMetricsClient(int period, boolean mute) {
		log.info("default metrics client create");
		timer = new Timer("default_metrics_client_timer", true);
		this.period = period;
		this.mute = mute;
	}




	@Override
	public MetricCounter counter(String metricsName, String description, SortedMap<String, String> tagMap) {
		return new MetricCounter() {
			private AtomicLong c = new AtomicLong(0);
			private String name = metricsName;
			private String desc = description;
			private SortedMap<String, String> map = tagMap;

			@Override
			public void increment() {
				if (!mute) {
					c.incrementAndGet();
					log.info("metrics name:{}, description={}, tags:{}, c={}", name, desc, map != null && !map.isEmpty() ? map.toString() : "", c);
				}
			}

			@Override
			public void incrementBy(long num) {
				if (!mute) {
					c.addAndGet(num);
					log.info("metric name:{}, description={}, tags:{}, c={}", name, desc, map != null && !map.isEmpty() ? map.toString() : "", c);
				}
			}
		};
	}

	@Override
	public MetricTimer timer(String metricsName, String descrtption, SortedMap<String, String> tagMap) {
		return new MetricTimer() {

			private int limit = 1_000_000;
			private SortedMap<Long, Long> storage = bulidStorage();

			private SortedMap<Long, Long> bulidStorage() {
				return Collections.synchronizedSortedMap(new TreeMap<>());
			}

			@Override
			public void record(long millis) {
				if (storage.size() >= limit) {
					storage = bulidStorage();
				}
				storage.put(System.currentTimeMillis(), millis);
				if (!mute) {
					log.info("time consumed:{}ms", millis);
				}
			}

			@Override
			public void record(long time, TimeUnit unit) {
				this.record(TimeUnit.MILLISECONDS.convert(time, unit));
			}
		};
	}

	@Override
	public void gauge(String metricsName, String description, SortedMap<String, String> tagMap, Callable<Double> callable) {
		try {
			if (!mute) {
				timer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						try {
							log.info("metric name:{}, description:{}, tagMap:{}, value:{}", metricsName, description, tagMap != null && !tagMap.isEmpty() ? tagMap.toString() : "", callable.call());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}, 0, period);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
