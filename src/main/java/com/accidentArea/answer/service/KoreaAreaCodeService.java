package com.accidentArea.answer.service;

import java.util.List;

import com.accidentArea.answer.dto.AreaCodeDTO;

public interface KoreaAreaCodeService {
	public List<AreaCodeDTO> koreaAreaCodeList(String depth) throws Exception;
	
	public List<AreaCodeDTO> koreaAreaCodeChildList(String parentCode) throws Exception;
}
