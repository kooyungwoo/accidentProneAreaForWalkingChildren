package com.accidentArea.answer.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accidentArea.answer.SearchParamVO;
import com.accidentArea.answer.dto.AreaCodeDTO;
import com.accidentArea.answer.service.ApiCallComp;
import com.accidentArea.answer.service.KoreaAreaCodeService;

@RestController("areaCodeController")
@RequestMapping("/areacode")
@CrossOrigin(origins = "*")
public class AreaCodeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("apiCallComp")
	private ApiCallComp apiCallComp;
	
	@Autowired
	@Qualifier("koreaAreaCodeService")
	private KoreaAreaCodeService koreaAreaCodeService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String dataList(@ModelAttribute SearchParamVO searchParam) throws Exception{
		return apiCallComp.callAccidentAreaInfo(searchParam);
	}
	
	@RequestMapping(value="/list/page/{searchPageNo}", method = RequestMethod.GET)
	public String dataPageList(@ModelAttribute SearchParamVO searchParam) throws Exception{
		return apiCallComp.callAccidentAreaInfo(searchParam);
	}
	
	@RequestMapping(value="/year/list", method = RequestMethod.GET)
	public ArrayList<String> yearList() throws Exception{
		ArrayList<String> yearList = new ArrayList<String>();
		yearList.add("2015");
		yearList.add("2016");
		yearList.add("2017");
		yearList.add("2018");
		yearList.add("2019");
		yearList.add("2020");
		yearList.add("2021");
		yearList.add("2022");
		return yearList;
	}
	
	@RequestMapping(value="/sido/list", method = RequestMethod.GET)
	public List<AreaCodeDTO> siDoList() throws Exception{
		return koreaAreaCodeService.koreaAreaCodeList("1");
	}
	
	@RequestMapping(value="/{searchSiDo}/gugun/list", method = RequestMethod.GET)
	public List<AreaCodeDTO> gugunList(@ModelAttribute SearchParamVO searchParam) throws Exception{
		return koreaAreaCodeService.koreaAreaCodeChildList(searchParam.getSearchSiDo());
	}
}
