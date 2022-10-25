package com.ssafy.webex.dto;

import lombok.Data;

@Data
public class City {
	private int id;
	private String name;
	private String countryCode;
	private String district;
	private int population;
}
