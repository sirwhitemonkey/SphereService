package com.xmdevelopments.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="products_price")
public class Price {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="products_price_id")
    private Integer ID;
    @Column(name="products_price_currency")
    private String currency;
    @Column(name="products_price_itemno")
    private String itemNo;
    @Column(name="products_price_pricelist")
    private String priceListCode;
    @Column(name="products_price_unitprice")
    private BigDecimal unitPrice;
    @JsonIgnore
    private Integer products_price_dpricetype;
    @Column(name="products_price_salestart")
    private Date saleStart;
    @Column(name="products_price_saleend")
    private Date saleEnd;
    @JsonIgnore
    private String products_price_qtyunit;
    @JsonIgnore
    private BigDecimal products_price_audtdate;
    @JsonIgnore
    private BigDecimal products_price_audttime;
    
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getPriceListCode() {
		return priceListCode;
	}
	public void setPriceListCode(String priceListCode) {
		this.priceListCode = priceListCode;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getProducts_price_dpricetype() {
		return products_price_dpricetype;
	}
	public void setProducts_price_dpricetype(Integer products_price_dpricetype) {
		this.products_price_dpricetype = products_price_dpricetype;
	}
	public Date getSaleStart() {
		return saleStart;
	}
	public void setSaleStart(Date saleStart) {
		this.saleStart = saleStart;
	}
	public Date getSaleEnd() {
		return saleEnd;
	}
	public void setSaleEnd(Date saleEnd) {
		this.saleEnd = saleEnd;
	}
	public String getProducts_price_qtyunit() {
		return products_price_qtyunit;
	}
	public void setProducts_price_qtyunit(String products_price_qtyunit) {
		this.products_price_qtyunit = products_price_qtyunit;
	}
	public BigDecimal getProducts_price_audtdate() {
		return products_price_audtdate;
	}
	public void setProducts_price_audtdate(BigDecimal products_price_audtdate) {
		this.products_price_audtdate = products_price_audtdate;
	}
	public BigDecimal getProducts_price_audttime() {
		return products_price_audttime;
	}
	public void setProducts_price_audttime(BigDecimal products_price_audttime) {
		this.products_price_audttime = products_price_audttime;
	}
    
    
    
    
 }
