package com.ssafy.hello.di4;

public class HelloMessageKor implements HelloMessage{

	public HelloMessageKor() {
		System.out.println("HelloMessageKor객체 만들어유!!");
	}
	
	public String hello(String name) {
		return "안녕" + name;
	}
}
