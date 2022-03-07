package com.accidentArea.answer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchParamVO {
	private String searchColumn;
	private String searchWord;
	private String searchYear="2022";
	private String searchSiDo="11";
	private String searchGuGun="680";
	private String searchPageNo="1";
}
