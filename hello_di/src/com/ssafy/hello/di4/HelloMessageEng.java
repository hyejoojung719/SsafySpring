package com.ssafy.hello.di4;

public class HelloMessageEng implements HelloMessage{

	public HelloMessageEng() {
		System.out.println("HelloMessageEng객체 만들어유!!");
//		init();	// 1. 객체가 메모리에 올라오기 전에 초기화 
	}
	
	public void init() {
		System.out.println("Eng 객체 초기화!");
	}
	
	public String hello(String name) {
		return "Hello" + name;
	}
}
