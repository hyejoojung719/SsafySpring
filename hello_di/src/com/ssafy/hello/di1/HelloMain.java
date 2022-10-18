package com.ssafy.hello.di1;

public class HelloMain {
	public static void main(String[] args) {
//		HelloMessageKor kor = new HelloMessageKor();
//		String greet = kor.helloKor("정혜주");
		HelloMessageEng eng = new HelloMessageEng();
		String greet = eng.helloEng("정혜주");
		System.out.println(greet);
		
		// 일일이 바꿔야하는 문제점이 있다 => 강한 결합
	}
}
