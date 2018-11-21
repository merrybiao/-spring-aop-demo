package com.hello.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hello.demo.ArithmeticCalculator;
import com.hello.demo.Say;
public class Test {
	public static void main2(String[] args) {
	ApplicationContext context= new ClassPathXmlApplicationContext("application.xml");
	 Say say =(Say)context.getBean("say");
	 say.say();
	}
	
	 public static void main(String[] args) throws Exception {
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
	        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
	        System.out.println(arithmeticCalculator.getClass());
	        /*int result = arithmeticCalculator.add(3, 5);
	        System.out.println("result: " + result);*/
	 
	       int  result = arithmeticCalculator.div(5, 0);
	        System.out.println("result: " + result);
	 
	    }

}
