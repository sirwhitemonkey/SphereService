package com.xmdevelopments.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity mapping {table=products} 
 *
 */
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="products_id")
    private Integer ID;
    @Column(name="products_itemno")
    private String itemNo;
    @JsonIgnore
    private String products_fmtitemno;
    @Column(name="products_desc")
    private String desc;
    @JsonIgnore
    private String products_category;
    @JsonIgnore
    private BigDecimal products_unitwgt;
    @Column(name="products_stockunit")
    private String stockunit;
    @JsonIgnore
    private String products_weightunit;
    @Column(name="products_inactive", columnDefinition = "BIT", length = 1)
    private boolean isNotActive;
    @Column(name="products_stockitem", columnDefinition = "BIT", length = 1)
	private boolean isInStock;
    @JsonIgnore   
    @Column(columnDefinition = "BIT", length = 1)
    private boolean products_display;
    @JsonIgnore
    private BigDecimal products_mxorder1;
    @JsonIgnore
    private BigDecimal products_mxorder2;
    @JsonIgnore
    private BigDecimal products_mxorder3;
    @JsonIgnore
    private BigDecimal products_lowlimit;
    @JsonIgnore
    private String products_altset;
    @Column(columnDefinition = "BIT", length = 1)
    @JsonIgnore
    private boolean products_kitting;
    @JsonIgnore
    private Integer products_boxsize;
    @JsonIgnore
    private String  products_length;
    @JsonIgnore
    private String products_width;
    @JsonIgnore
    private String products_height;
    @JsonIgnore
    private  String products_itembrkid;
    @JsonIgnore
    private String products_segment1;
    @JsonIgnore
    private String products_segment2;
    @JsonIgnore
    private String products_segment3;
    @JsonIgnore
    private String products_segment4;
    @JsonIgnore
    private String products_segment5;
    @JsonIgnore
    private String products_segment6;
    @JsonIgnore
    private String products_segment7;
    @JsonIgnore
    private String products_segment8;
    @JsonIgnore
    private String products_segment9;
    @JsonIgnore
    private String products_segment10;
    @JsonIgnore
    private String products_stocknote;
    @Column(columnDefinition = "BIT", length = 1)
    @JsonIgnore
    private boolean products_serialno;
    @JsonIgnore
    private String products_seo;
    @JsonIgnore
    private String products_meta_title;
    @JsonIgnore
    private String products_meta_description;
    @JsonIgnore
    private String products_meta_keywords;
    @JsonIgnore
    private BigDecimal products_shipping_surcharge;
    @JsonIgnore
    private Integer products_shipping_restriction_id;
    @Column(name="products_commodim")    
    private String upcCode;
    @JsonIgnore
    private Integer products_free_shipping;
    @JsonIgnore
    private  String products_defpriclst;
    @JsonIgnore
    private Integer products_rowid;
    @JsonIgnore
    private String products_comments;
    @JsonIgnore
    private BigDecimal products_baseprice;
    @JsonIgnore
    private String products_vacitm_0;
    @JsonIgnore
    private String products_vacitm_1;
    @JsonIgnore
    private String products_vacitm_2;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public String getProducts_fmtitemno() {
		return products_fmtitemno;
	}
	public void setProducts_fmtitemno(String products_fmtitemno) {
		this.products_fmtitemno = products_fmtitemno;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getProducts_category() {
		return products_category;
	}
	public void setProducts_category(String products_category) {
		this.products_category = products_category;
	}
	public BigDecimal getProducts_unitwgt() {
		return products_unitwgt;
	}
	public void setProducts_unitwgt(BigDecimal products_unitwgt) {
		this.products_unitwgt = products_unitwgt;
	}
	public String getStockunit() {
		return stockunit;
	}
	public void setStockunit(String stockunit) {
		this.stockunit = stockunit;
	}
	public String getProducts_weightunit() {
		return products_weightunit;
	}
	public void setProducts_weightunit(String products_weightunit) {
		this.products_weightunit = products_weightunit;
	}
	public boolean isNotActive() {
		return isNotActive;
	}
	public void setNotActive(boolean isNotActive) {
		this.isNotActive = isNotActive;
	}
	public boolean isInStock() {
		return isInStock;
	}
	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}
	public boolean isProducts_display() {
		return products_display;
	}
	public void setProducts_display(boolean products_display) {
		this.products_display = products_display;
	}
	public BigDecimal getProducts_mxorder1() {
		return products_mxorder1;
	}
	public void setProducts_mxorder1(BigDecimal products_mxorder1) {
		this.products_mxorder1 = products_mxorder1;
	}
	public BigDecimal getProducts_mxorder2() {
		return products_mxorder2;
	}
	public void setProducts_mxorder2(BigDecimal products_mxorder2) {
		this.products_mxorder2 = products_mxorder2;
	}
	public BigDecimal getProducts_mxorder3() {
		return products_mxorder3;
	}
	public void setProducts_mxorder3(BigDecimal products_mxorder3) {
		this.products_mxorder3 = products_mxorder3;
	}
	public BigDecimal getProducts_lowlimit() {
		return products_lowlimit;
	}
	public void setProducts_lowlimit(BigDecimal products_lowlimit) {
		this.products_lowlimit = products_lowlimit;
	}
	public String getProducts_altset() {
		return products_altset;
	}
	public void setProducts_altset(String products_altset) {
		this.products_altset = products_altset;
	}
	public boolean isProducts_kitting() {
		return products_kitting;
	}
	public void setProducts_kitting(boolean products_kitting) {
		this.products_kitting = products_kitting;
	}
	public Integer getProducts_boxsize() {
		return products_boxsize;
	}
	public void setProducts_boxsize(Integer products_boxsize) {
		this.products_boxsize = products_boxsize;
	}
	public String getProducts_length() {
		return products_length;
	}
	public void setProducts_length(String products_length) {
		this.products_length = products_length;
	}
	public String getProducts_width() {
		return products_width;
	}
	public void setProducts_width(String products_width) {
		this.products_width = products_width;
	}
	public String getProducts_height() {
		return products_height;
	}
	public void setProducts_height(String products_height) {
		this.products_height = products_height;
	}
	public String getProducts_itembrkid() {
		return products_itembrkid;
	}
	public void setProducts_itembrkid(String products_itembrkid) {
		this.products_itembrkid = products_itembrkid;
	}
	public String getProducts_segment1() {
		return products_segment1;
	}
	public void setProducts_segment1(String products_segment1) {
		this.products_segment1 = products_segment1;
	}
	public String getProducts_segment2() {
		return products_segment2;
	}
	public void setProducts_segment2(String products_segment2) {
		this.products_segment2 = products_segment2;
	}
	public String getProducts_segment3() {
		return products_segment3;
	}
	public void setProducts_segment3(String products_segment3) {
		this.products_segment3 = products_segment3;
	}
	public String getProducts_segment4() {
		return products_segment4;
	}
	public void setProducts_segment4(String products_segment4) {
		this.products_segment4 = products_segment4;
	}
	public String getProducts_segment5() {
		return products_segment5;
	}
	public void setProducts_segment5(String products_segment5) {
		this.products_segment5 = products_segment5;
	}
	public String getProducts_segment6() {
		return products_segment6;
	}
	public void setProducts_segment6(String products_segment6) {
		this.products_segment6 = products_segment6;
	}
	public String getProducts_segment7() {
		return products_segment7;
	}
	public void setProducts_segment7(String products_segment7) {
		this.products_segment7 = products_segment7;
	}
	public String getProducts_segment8() {
		return products_segment8;
	}
	public void setProducts_segment8(String products_segment8) {
		this.products_segment8 = products_segment8;
	}
	public String getProducts_segment9() {
		return products_segment9;
	}
	public void setProducts_segment9(String products_segment9) {
		this.products_segment9 = products_segment9;
	}
	public String getProducts_segment10() {
		return products_segment10;
	}
	public void setProducts_segment10(String products_segment10) {
		this.products_segment10 = products_segment10;
	}
	public String getProducts_stocknote() {
		return products_stocknote;
	}
	public void setProducts_stocknote(String products_stocknote) {
		this.products_stocknote = products_stocknote;
	}
	public boolean isProducts_serialno() {
		return products_serialno;
	}
	public void setProducts_serialno(boolean products_serialno) {
		this.products_serialno = products_serialno;
	}
	public String getProducts_seo() {
		return products_seo;
	}
	public void setProducts_seo(String products_seo) {
		this.products_seo = products_seo;
	}
	public String getProducts_meta_title() {
		return products_meta_title;
	}
	public void setProducts_meta_title(String products_meta_title) {
		this.products_meta_title = products_meta_title;
	}
	public String getProducts_meta_description() {
		return products_meta_description;
	}
	public void setProducts_meta_description(String products_meta_description) {
		this.products_meta_description = products_meta_description;
	}
	public String getProducts_meta_keywords() {
		return products_meta_keywords;
	}
	public void setProducts_meta_keywords(String products_meta_keywords) {
		this.products_meta_keywords = products_meta_keywords;
	}
	public BigDecimal getProducts_shipping_surcharge() {
		return products_shipping_surcharge;
	}
	public void setProducts_shipping_surcharge(BigDecimal products_shipping_surcharge) {
		this.products_shipping_surcharge = products_shipping_surcharge;
	}
	public Integer getProducts_shipping_restriction_id() {
		return products_shipping_restriction_id;
	}
	public void setProducts_shipping_restriction_id(Integer products_shipping_restriction_id) {
		this.products_shipping_restriction_id = products_shipping_restriction_id;
	}
	public String getUpcCode() {
		return upcCode;
	}
	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}
	public Integer getProducts_free_shipping() {
		return products_free_shipping;
	}
	public void setProducts_free_shipping(Integer products_free_shipping) {
		this.products_free_shipping = products_free_shipping;
	}
	public String getProducts_defpriclst() {
		return products_defpriclst;
	}
	public void setProducts_defpriclst(String products_defpriclst) {
		this.products_defpriclst = products_defpriclst;
	}
	public Integer getProducts_rowid() {
		return products_rowid;
	}
	public void setProducts_rowid(Integer products_rowid) {
		this.products_rowid = products_rowid;
	}
	public String getProducts_comments() {
		return products_comments;
	}
	public void setProducts_comments(String products_comments) {
		this.products_comments = products_comments;
	}
	public BigDecimal getProducts_baseprice() {
		return products_baseprice;
	}
	public void setProducts_baseprice(BigDecimal products_baseprice) {
		this.products_baseprice = products_baseprice;
	}
	public String getProducts_vacitm_0() {
		return products_vacitm_0;
	}
	public void setProducts_vacitm_0(String products_vacitm_0) {
		this.products_vacitm_0 = products_vacitm_0;
	}
	public String getProducts_vacitm_1() {
		return products_vacitm_1;
	}
	public void setProducts_vacitm_1(String products_vacitm_1) {
		this.products_vacitm_1 = products_vacitm_1;
	}
	public String getProducts_vacitm_2() {
		return products_vacitm_2;
	}
	public void setProducts_vacitm_2(String products_vacitm_2) {
		this.products_vacitm_2 = products_vacitm_2;
	}
	
    
 }
