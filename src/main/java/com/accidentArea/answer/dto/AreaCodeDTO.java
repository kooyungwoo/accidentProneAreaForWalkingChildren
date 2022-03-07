package com.accidentArea.answer.dto;

import com.accidentArea.dmain.AreaCode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AreaCodeDTO {
    private String areaCode;
	private String areaName;
	private String parentCode;
	private Integer viewOrder;
	
	public AreaCode dtoToEntity() {
		AreaCode areaCode = AreaCode.ByAllBuilder().areaCode(this.areaCode).areaName(this.areaName).parentCode(this.parentCode).viewOrder(this.viewOrder).build();
		return areaCode;
    }
}
