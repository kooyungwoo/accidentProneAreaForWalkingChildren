package com.accidentArea.answer.web;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accidentArea.answer.SearchParamVO;

@RestController("areaCodeController")
@RequestMapping("**/area-code")
@CrossOrigin(origins = "*")
public class AreaCodeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ArrayList<Object> msgList(@ModelAttribute SearchParamVO searchParam) throws Exception{
		return null;
	}
}
