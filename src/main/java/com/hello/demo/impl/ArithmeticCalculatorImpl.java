package com.hello.demo.impl;

import org.springframework.stereotype.Component;

import com.hello.demo.ArithmeticCalculator;
 
//将实现类加入Spring的IOC容器进行管理
@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
 
    public int add(int i, int j) throws Exception{
        int result = i + j;
        return result;
    }
 
    public int sub(int i, int j) throws Exception{
        int result = i - j;
        return result;
    }
 
    public int mul(int i, int j) throws Exception{
        int result = i * j;
        return result;
    }
 
    public int div(int i, int j) throws Exception{
        int result = i / j;
        return result;
    }
 
}
