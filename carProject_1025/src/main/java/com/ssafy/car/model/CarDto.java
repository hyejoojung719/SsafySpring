package com.ssafy.car.model;

import lombok.Data;

@Data
public class CarDto {
	private String number;
	private String model;
	private int price;
	private String brand;
	private FileInfoDto fileInfo;
}
