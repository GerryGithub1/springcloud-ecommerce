package com.lmq.common.base;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;


@Aspect
//�����Ǹ�spring�����bean
@Component
@Slf4j
public class LogAspectServiceApi {
	private JSONObject jsonObject = new JSONObject();

	// ����һ���е� ������ execution���ʽ
	@Pointcut("execution(public * com.lmq.serviceimpl.*.*(..))")
	private void controllerAspect() {
	}

	// ����methodǰ��ӡ����
	@Before(value = "controllerAspect()")
	public void methodBefore(JoinPoint joinPoint) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		log.info("===============��������===============");
		try {
			// ��ӡ��������
			log.info("�����ַ:" + request.getRequestURL().toString());
			log.info("����ʽ:" + request.getMethod());
			log.info("�����෽��:" + joinPoint.getSignature());
			log.info("�����෽������:" + Arrays.toString(joinPoint.getArgs()));
		} catch (Exception e) {
			log.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
		}
		log.info("===============��������===============");
	}

	// �ڷ���ִ�������ӡ��������
	@AfterReturning(returning = "o", pointcut = "controllerAspect()")
	public void methodAfterReturing(Object o) {
		log.info("--------------��������----------------");
		try {
			log.info("Response����:" + jsonObject.toJSONString(o));
		} catch (Exception e) {
			log.error("###LogAspectServiceApi.class methodAfterReturing() ### ERROR:", e);
		}
		log.info("--------------��������----------------");
	}
}
