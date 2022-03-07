package com.accidentArea.answer.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.accidentArea.answer.dto.AreaCodeDTO;
import com.accidentArea.answer.service.KoreaAreaCodeService;
import com.accidentArea.dmain.AreaCode;
import com.accidentArea.repository.KoreaAreaCodeRepository;

@Service("koreaAreaCodeService")
public class KoreaAreaCodeServiceImpl implements KoreaAreaCodeService {
	@Resource(name="koreaAreaCodeRepository")
	private KoreaAreaCodeRepository koreaAreaCodeRepository;
	
	@Override
	public List<AreaCodeDTO> koreaAreaCodeList(String depth) throws Exception {
		List<AreaCode> dataList 					= koreaAreaCodeRepository.findByAreaDepth(depth, Sort.by(Sort.Direction.ASC, "viewOrder"));
		List<AreaCodeDTO> areaCodeList 	= dataList.stream().map(AreaCode::entityToDTO).collect(Collectors.toList());
		return areaCodeList;
	}

	@Override
	public List<AreaCodeDTO> koreaAreaCodeChildList(String parentCode) throws Exception {
		List<AreaCode> dataList 					= koreaAreaCodeRepository.findByParentCode(parentCode, Sort.by(Sort.Direction.ASC, "viewOrder"));
		List<AreaCodeDTO> areaCodeList 	= dataList.stream().map(AreaCode::entityToDTO).collect(Collectors.toList());
		return areaCodeList;
	}

}
