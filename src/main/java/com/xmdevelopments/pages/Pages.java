package com.xmdevelopments.pages;

import java.util.List;

import org.springframework.data.domain.Page;

public class Pages {

	private MetaData metadata;

	@SuppressWarnings("rawtypes")
	private Page page;

	@SuppressWarnings("rawtypes")
	public Pages(Page page) {
		this.page = page;
		this.metadata = new MetaData(page);
	}

	@SuppressWarnings("unchecked")
	public List<Object> getContent() {
		return page.getContent();
	}

	public MetaData getMetadata() {
		return metadata;
	}
}
