package com.xmdevelopments.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pricelists")
public class PriceList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pricelists_id")
	private Integer ID;

	@Column(name = "pricelists_code")
	private String priceListCode;

	@Column(name = "pricelists_desc")
	private String priceListDesc;

	@Column(name = "pricelists_exclude", columnDefinition = "BIT", length = 1)
	private boolean isExclude;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getPriceListCode() {
		return priceListCode;
	}

	public void setPriceListCode(String priceListCode) {
		this.priceListCode = priceListCode;
	}

	public String getPriceListDesc() {
		return priceListDesc;
	}

	public void setPriceListDesc(String priceListDesc) {
		this.priceListDesc = priceListDesc;
	}

	public boolean isExclude() {
		return isExclude;
	}

	public void setExclude(boolean isExclude) {
		this.isExclude = isExclude;
	}

	

}
