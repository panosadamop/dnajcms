package com.dnacreative.module.content.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dnacreative.module.content.model.Content;

@Service
public interface ContentService {

	public void save(Content content, MultipartFile file);
		
	public void update(Content content, MultipartFile file, Map<String, String[]> parameterMap);
	
	public Page<Content> findAll(Pageable pageRequest);

	public void deleteById(Long id);
	
	public String getCategorySelectOptionRaw();

	public String getCategorySelectOption(Integer selected_id, Integer parent);

	public Content findByIdForShow(Long id);
	
	public Content findById(Long id);

	public Page<Content> getForCatListContents(Integer categoryId, int page, int pageSize);

	public Page<Content> getLatestContent(int size);

}
