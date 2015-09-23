package com.xmdevelopments.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arcus_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="arcus_customers_id")    
    private Integer ID;
    
    @Column(name="arcus_customers_name")
    private String name;
    
    @Column(name="arcus_customers_code")
    private String code;
    
    @Column(name="arcus_customers_address1")
    private String address1;    

    @Column(name="arcus_customers_address2")
    private String address2;
    
    @Column(name="arcus_customers_address3")
    private String address3;
    
    @Column(name="arcus_customers_address4")
    private String address4;    

    @Column(name="arcus_customers_email")
    private String email;    
    
    @Column(name="arcus_customers_price_code")
    private String priceCode;
    
    @Column(name="arcus_customers_status")
    private String status;
    
    @Column(name="arcus_customers_currency_used")
    private String curreny;        
    
    @Column(name="arcus_customers_customer_group")
    private String group;
    
    @Column(name="arcus_customers_tax_group")
    private String taxGroup;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurreny() {
		return curreny;
	}

	public void setCurreny(String curreny) {
		this.curreny = curreny;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getTaxGroup() {
		return taxGroup;
	}

	public void setTaxGroup(String taxGroup) {
		this.taxGroup = taxGroup;
	}
    
    
}