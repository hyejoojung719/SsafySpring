package com.ssafy.mvc.dto;

import lombok.Data;

@Data
public class Book {
	private String isbn;
	private String title;
	private String author;
	private int price;
	private String description;
	private String img;
	private FileInfo fileInfo;
	
}
