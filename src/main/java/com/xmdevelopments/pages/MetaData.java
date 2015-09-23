package com.xmdevelopments.pages;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public class MetaData {

	private Page<Object> page;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MetaData(Page page) {
		this.page = page;
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

}
