package com.ssafy.hello.di2;

public class HelloMain {
	public static void main(String[] args) {
//		HelloMessageKor kor = new HelloMessageKor();
//		String greet = kor.helloKor("정혜주");
//		HelloMessageEng eng = new HelloMessageEng();
//		String greet = eng.helloEng("정혜주");
		// 일일이 바꿔야하는 문제점이 있다 => 강한 결합
		
		// 개선
		HelloMessage hello = new HelloMessageKor();
		String greet = hello.hello("안효인");
		System.out.println(greet);
		// 그러나 main안에서 객체를 만드는게 문제!
		
		
	}
}
