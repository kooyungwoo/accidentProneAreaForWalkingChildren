package com.accidentArea.answer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccidentAreaDTO {
	private String afosFid; //다발지역FID
	private String afosId; //다발지역ID
	private String bjdCd; //법정동코드
	private String spotCd; //지점코드
	private String sidoSggNm; //시도시군구명
	private String spotNm; //지점명
	private String occrrncCnt; //발생건수
	private String casltCnt; //사상자수
	private String dthDnvCnt; //사망자수
	private String seDnvCnt; //중상자수
	private String slDnvCnt; //경상자수
	private String wndDnvCnt; //부상신고자수
	private String geomJson; //다발지역폴리곤
	private String loCrd; //경도
	private String laCrd; //위도

	//totalCount 총건수
	//numOfRows 검색건수
	//pageNo 페이지 번호

	//resultCode 코드결과 
	//resultMsg 결과 메시지
}
