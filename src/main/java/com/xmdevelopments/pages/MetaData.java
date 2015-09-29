package com.xmdevelopments.pages;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public class MetaData {

	private Page<Object> page;
	private long date_last_updated;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MetaData(Page page) {
		this.page = page;
		Date date = new java.util.Date(); 
		long unixTime = (long)date.getTime()/1000;
		setDate_last_updated(unixTime);
	}

	public long getTotalElements() {
		return page.getTotalElements();
	}

	public long getTotalPages() {
		return page.getTotalPages();
	}

	public boolean isLast() {
		return page.isLast();
	}

	public boolean isFirst() {
		return page.isFirst();
	}

	public int getNumberOfElements() {
		return page.getNumberOfElements();
	}

	public Sort getSort() {
		return page.getSort();
	}

	public int getSize() {
		return page.getSize();
	}

	public int getNumber() {
		return page.getNumber();
	}

	public long getDate_last_updated() {
		return date_last_updated;
	}

	public void setDate_last_updated(long date_last_updated) {
		this.date_last_updated = date_last_updated;
	}
}
