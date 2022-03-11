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
	private String searchYear="2017";//2017년 이후 데이터는 공공데이터포털에 거의 없어서 2017년으로 기본설정
	private String searchSiDo="11680";//서울시
	private String searchGuGun="11680";//강남구
	private String searchPageNo="1";//1페이지
}
