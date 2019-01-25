package com.dnacreative.module.page.service;

import java.util.List;

import com.dnacreative.module.page.model.Page;

public interface PageService {

	void save(Page page);

	List<Page> findAll() ;

	Page findById(Integer pId);
	
	void update(Page p1);
	
	void delete(Page page);

	void deleteById(int id);
	
	String getPageSelectOptionRaw();

	String getPageSelectOptionRawWithSelected(Long referId);
}
