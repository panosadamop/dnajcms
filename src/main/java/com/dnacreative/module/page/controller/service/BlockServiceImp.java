package com.dnacreative.module.page.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.dnacreative.module.category.model.Category;
import com.dnacreative.module.category.service.CategoryService;
import com.dnacreative.module.content.model.Content;
import com.dnacreative.module.content.service.ContentService;

@Service
public class BlockServiceImp implements BlockService {

	@Autowired
	ContentService contentService;
	
	@Autowired
	CategoryService categoryService;
	
	/*@Cacheable(value="latestContents")*/
/*	@CacheEvict(value="latestContents")*/
	@Override
	public Page<Content> getLatestContents() {
		/*return contentService.getLatestContent(3);*/
		Page<Content> contents = contentService.getLatestContent(3);
		
		System.out.println("getLatestContents: "+contents);
		
		return contents;
		
	}
	
/*@Cacheable(value="contentCategories")*/
	/*@CacheEvict*/
	@Override
	public List<Category> getContentCategories() {
		return categoryService.getModuleCategoriesByName("content");
		
	}
}
