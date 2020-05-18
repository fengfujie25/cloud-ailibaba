package com.cloud.ailibaba.providerserver.aspect;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author fujie.feng
 * @Date 2020-05-14
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

	// 日志格式 类名、方法名、参数
	private static final String LOG_FORMAT = "{}|{}|{}";

	@Pointcut("@annotation(com.cloud.ailibaba.providerserver.annotation.Log)")
	public void log() {}

	@Pointcut("execution(* com.cloud.ailibaba.providerserver.controller..*.*(..))")
	public void exceptionLog(){}

	/**
	 * 正常返回，如果执行异常则不执行
	 * @param joinPoint 切入点
	 * @param result 返回结果
	 */
	@AfterReturning(value = "log()", returning = "result")
	public void after(JoinPoint joinPoint, Object result) {
		RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = (HttpServletRequest) attributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

		try {
			String className = joinPoint.getTarget().getClass().getName();

			MethodSignature signature = (MethodSignature) joinPoint.getSignature();
			String methodName = signature.getMethod().getName();
			Map<String, String> params = Maps.newHashMap();
			Map<String, String[]> map = request.getParameterMap();
			request.getParameterMap().forEach((k, v) -> {
				params.put(k, map.get(k)[0]);
			});
			log.info(LOG_FORMAT, className, methodName, JSON.toJSONString(joinPoint.getArgs()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterThrowing(pointcut = "exceptionLog()", throwing = "ex")
	public void afterException(JoinPoint joinPoint, Throwable ex) {
		log.info(LOG_FORMAT, ex.getMessage(), ex.getCause(), ex.getClass().getName());
	}
}
