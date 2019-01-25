package com.dnacreative.module.page.controller.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dnacreative.module.category.model.Category;
import com.dnacreative.module.content.model.Content;

public interface BlockService {

	public Page<Content> getLatestContents();
	
	public List<Category> getContentCategories();
}
