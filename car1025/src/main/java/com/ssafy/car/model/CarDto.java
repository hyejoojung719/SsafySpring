package com.ssafy.car.model;

import java.util.List;

import lombok.Data;

@Data
public class CarDto {
	private String number;
	private String model;
	private int price;
	private String brand;
	private List<FileInfoDto> fileInfo;
}
