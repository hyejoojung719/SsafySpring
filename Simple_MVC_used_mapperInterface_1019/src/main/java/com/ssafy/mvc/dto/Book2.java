package com.ssafy.mvc.dto;

import lombok.Data;
import lombok.NonNull;

//@Getter // getter 어노테이션을 붙이면 해당 변수에대한 get 메소드가 생긴다(outline 참고)
//@Setter
//@ToString
//@Slf4j	// logger 변수 추가
//@AllArgsConstructor	// 생성자 추가(전체 멤버 변수 다 있는)
//@NoArgsConstructor	// 멤벼 변수 없는 생성자 추가
//@EqualsAndHashCode	// equals 메소드와 hashcode메소드 추가

@Data	// Getter, Setter, ToString, EqualsAndHashCode, RequiredArgsConstructor
public class Book2 {
	@NonNull // 바로 밑에 있는 거 하나만 해당
	private String isbn;
	private String title;
	private String author;
	private int price;
	private String description;
	private String img;
	
}
