//package com.cloud.ailibaba.providerserver.aspect;
//
//import com.alibaba.fastjson.JSON;
//import com.netflix.ribbon.proxy.annotation.Http;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//import java.util.Objects;
//
///**
// * @author fujie.feng
// * @Date 2020-05-13
// */
//@Aspect
//@Component
//@Slf4j
//public class AopLog {
//
//	private static final String REQUEST_START_TIME = "request_start_time";
//
//	@Pointcut("execution(public * com.cloud.ailibaba.providerserver.controller.*Controller.*(..))")
//	public void log() {
//	}
//
//	@Before("log()")
//	public void before(JoinPoint joinPoint) {
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
//
//		log.info("request url:{}", request.getRequestURL());
//		log.info("request ip:{}", request.getRemoteAddr());
//		log.info("request class name:{}, request method name:{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
//
//		Map<String, String[]> map = request.getParameterMap();
//
//
//		log.info("request params:{}", JSON.toJSONString(joinPoint.getArgs()));
//		Long start = System.currentTimeMillis();
//		request.setAttribute(REQUEST_START_TIME, start);
//	}
//
//	@Around("log()")
//	public Object around(ProceedingJoinPoint point) throws Throwable {
//		Object result = point.proceed();
//		log.info("result:{}", JSON.toJSONString(result));
//		return result;
//	}
//
//	@After("log()")
//	public void after() {
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
//
//		Long start = (Long) request.getAttribute(REQUEST_START_TIME);
//		Long end = System.currentTimeMillis();
//		log.info("process time:{}ms", (end - start));
//	}
//}

