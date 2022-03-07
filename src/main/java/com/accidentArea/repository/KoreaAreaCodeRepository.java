package com.accidentArea.repository;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accidentArea.dmain.AreaCode;

@Repository("koreaAreaCodeRepository")
public interface KoreaAreaCodeRepository extends JpaRepository<AreaCode, String>{
	
	//depth에 해당하는 지역코드 목록
	List<AreaCode> findByAreaDepth(String areaDepth, Sort sort);
	
	//parentCode에 해당하는 지역코드 목록
	List<AreaCode> findByParentCode(String parentCode, Sort sort);
}
