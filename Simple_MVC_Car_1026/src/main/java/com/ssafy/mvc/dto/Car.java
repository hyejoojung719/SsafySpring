package com.ssafy.mvc.dto;

import lombok.Data;

@Data
public class Car {

	private String number;
	private String model;
	private int price;
	private String brand; 
	
	private FileInfo fileInfo;
}
