package com.accidentArea.dmain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.accidentArea.answer.dto.AreaCodeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "KOREA_AREA_CODE")
public class AreaCode implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "AREA_CODE", nullable=false, insertable=true, updatable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String areaCode;
	
	@Column(name = "AREA_NAME", length=100, nullable=true, insertable=true, updatable=true)
	private String areaName;
	
	@Column(name = "PARENT_CODE", length=10, nullable=true, insertable=true, updatable=true)
	private String parentCode;
	
	@Column(name = "VIEW_ORDER", nullable=true, insertable=true, updatable=true)
	private Integer viewOrder;
	
	@Column(name = "AREA_DEPTH", length=2, nullable=true, insertable=true, updatable=true)
	private String areaDepth;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)//LAZY 지연호출, EAGER 즉시호출
    @JoinColumn(name = "PARENT_CODE", insertable=false, updatable=false)
    private AreaCode parent;
	
	@JsonProperty("nodes")
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_CODE")
	@OrderBy("viewOrder asc")
	private List<AreaCode> children = new ArrayList<AreaCode>();
	
	@Builder(builderClassName = "ByAreaCodeBuilder", builderMethodName = "ByAllBuilder")
	public AreaCode(String areaCode, String areaName, String parentCode, Integer viewOrder) {
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.parentCode = parentCode;
		this.viewOrder = viewOrder;
	}
	
	public AreaCodeDTO entityToDTO() {
		AreaCodeDTO areaCodeDTO = new AreaCodeDTO();
		ModelMapper mMapper = new ModelMapper();
		mMapper.map(this, areaCodeDTO); 
		
		return areaCodeDTO;
    }
}
