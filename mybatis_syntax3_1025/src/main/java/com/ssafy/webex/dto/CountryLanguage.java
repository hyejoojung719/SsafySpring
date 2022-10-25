package com.ssafy.webex.dto;

import lombok.Data;

@Data
public class CountryLanguage {
	private String countryCode;
	private String language;
	private String isOfficial;
	private double percentage;
}
