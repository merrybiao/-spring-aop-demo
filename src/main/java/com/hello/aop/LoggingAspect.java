package com.hello.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
 
/**
 * ��־����
 * 
 * @author XiaoYe 
 * @date 2017��1��1�� ����4:14:34
 */
@Component
@Aspect
public class LoggingAspect {
 
    /**
     * ǰ��֪ͨ��Ŀ�귽��ִ��֮ǰִ�����·���������� 
     * @param jp
     */
    @Before("execution(* com.hello.demo.impl.*.*(..))")
    public void beforeMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        System.out.println("��ǰ��֪ͨ��the method ��" + methodName + "�� begins with " + Arrays.asList(jp.getArgs()));
    }
 
    /**
     * ����֪ͨ��Ŀ�귽������ִ�����ʱִ�����´���
     * @param jp
     * @param result
     */
    @AfterReturning(value="execution(* com.hello.demo.impl.*.*(..))",returning="result")
    public void afterReturningMethod(JoinPoint jp, Object result){
        String methodName = jp.getSignature().getName();
        System.out.println("������֪ͨ��the method ��" + methodName + "�� ends with ��" + result + "��");
    }
 
    /**
     * ����֪ͨ��Ŀ�귽��ִ��֮��ִ�����·���������ݣ������Ƿ����쳣��
     * @param jp
     */
    @After("execution(* com.hello.demo.impl.*.*(..))")
    public void afterMethod(JoinPoint jp){
        System.out.println("������֪ͨ��this is a afterMethod advice...");
    }
 
    /**
     * �쳣֪ͨ��Ŀ�귽�������쳣��ʱ��ִ�����´���
     */
    @AfterThrowing(value="execution(* com.hello.demo.impl.*.*(..))",throwing="e")
    public void afterThorwingMethod(Throwable e){
        System.out.println("���쳣֪ͨ��the method  occurs exception: " + e);
    }
 
/*  *//**
   * ����֪ͨ��Ŀ�귽��ִ��ǰ��ֱ�ִ��һЩ���룬�����쳣��ʱ��ִ������һЩ����
   * @return 
   *//*
  @Around(value="execution(* com.hello.demo.impl.*.*(..))")
  public Object aroundMethod(ProceedingJoinPoint jp){
      String methodName = jp.getSignature().getName();
      Object result = null;
      try {
          System.out.println("������֪ͨ�е�--->ǰ��֪ͨ����the method ��" + methodName + "�� begins with " + Arrays.asList(jp.getArgs()));
          //ִ��Ŀ�귽��
          result = jp.proceed();
          System.out.println("������֪ͨ�е�--->����֪ͨ����the method ��" + methodName + "�� ends with " + result);
      } catch (Throwable e) {
          System.out.println("������֪ͨ�е�--->�쳣֪ͨ����the method ��" + methodName + "�� occurs exception " + e);
      }
      
      System.out.println("������֪ͨ�е�--->����֪ͨ����-----------------end.----------------------");
      return result;
  }*/
 
}

