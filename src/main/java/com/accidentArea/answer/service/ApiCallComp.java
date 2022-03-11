package com.accidentArea.answer.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.accidentArea.answer.SearchParamVO;

@Component("apiCallComp")
public class ApiCallComp {
	private String serviceUrl = "http://apis.data.go.kr/B552061/frequentzoneChild/getRestFrequentzoneChild";
	
	//application.properties의 설정 정보를 가지고 올때 @Value("${설정key}") 형식으로 호출
	@Value("${openApi.serviceKey}")
	private String serviceKey;
	
	public String callAccidentAreaInfo(SearchParamVO paramVO) throws ClientProtocolException, IOException {
		HttpClient client 				= HttpClientBuilder.create().build();
        HttpGet request 				= new HttpGet(serviceUrl+"?"+URLEncodedUtils.format(makeParameterList(paramVO.getSearchYear(), paramVO.getSearchSiDo(), paramVO.getSearchGuGun(), paramVO.getSearchPageNo()), "utf-8"));
        HttpResponse response 	= client.execute(request);
        HttpEntity entity 				= response.getEntity();
        
        String returnJson				= EntityUtils.toString(entity, "UTF-8");
		return returnJson;
	}
	
	public List<BasicNameValuePair> makeParameterList(String searchYearCd, String siDo, String guGun, String searchPageNo){
		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		
        params.add(new BasicNameValuePair("ServiceKey", serviceKey));
        params.add(new BasicNameValuePair("type", "json"));
        params.add(new BasicNameValuePair("searchYearCd", searchYearCd));
        params.add(new BasicNameValuePair("siDo", makeSiDoCode(siDo)));
        params.add(new BasicNameValuePair("guGun", makeGuGunCode(guGun)));
        params.add(new BasicNameValuePair("numOfRows", "10"));
        params.add(new BasicNameValuePair("pageNo", searchPageNo));        
        
        return params;
	}
	
	//법정동 코드값 앞 2자리만 사용 (ex>4111100000 -> 41)
	public String makeSiDoCode(String siDo) {
		return StringUtils.substring(siDo, 0, 2);
	}
	//법정동 코드값 2~5자리만 사용  (ex>4111100000 -> 111)
	public String makeGuGunCode(String guGun) {
		return StringUtils.substring(guGun, 2, 5);
	}
	
	/*
	 URIBuilder builder = new URIBuilder();
	builder.setScheme("http").setHost(host).setPort(port).setPath(yourpath)
	.setParameter("parts", "all")
	.setParameter("action", "finish");
	 */	
	
	//http://apis.data.go.kr/B552061/frequentzoneChild/getRestFrequentzoneChild?ServiceKey=EtJfB1nu62e79mlcOeOOL8k49BIKChfZAdIc3PbFAfIzM6yLr71kyikvvMdEyj7WAO1VExFUf0q2hdivC9upLQ==&searchYearCd=2017&siDo=11&guGun=680&numOfRows=10&pageNo=1&type=json
}
