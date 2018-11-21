package com.hello.demo.impl;

import com.hello.demo.Say;

public class SayHello implements Say {

	 private String name;
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void say() {
	System.out.println("hello,"+name);
   }
}
