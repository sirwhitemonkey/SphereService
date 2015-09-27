package com.xmdevelopments.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pricelists")
public class PriceList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pricelists_id")
	private Integer ID;

	@Column(name="pricelists_code")
	private String code;

	@Column(name="pricelists_desc")
	private String desc;

	@Column(name="pricelists_exclude", columnDefinition = "BIT", length = 1)
	@JsonIgnore
	private boolean isExclude;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isExclude() {
		return isExclude;
	}

	public void setExclude(boolean isExclude) {
		this.isExclude = isExclude;
	}

	
	
}
