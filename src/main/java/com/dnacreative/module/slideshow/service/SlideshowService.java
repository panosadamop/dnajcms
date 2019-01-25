package com.dnacreative.module.slideshow.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.dnacreative.module.slideshow.model.Slideshow;
import com.dnacreative.module.slideshow.model.SlideshowItem;
import com.dnacreative.module.slideshow.repository.SlideshowRepository;

public interface SlideshowService {

	List<Slideshow> findAll();

	Slideshow getForEditItems(Integer slideshowId);

	void setSlideshowRepository(SlideshowRepository slideshowRepository);

	Set<SlideshowItem> findDeletedItems(Slideshow slideshow, Map<String, String[]> parameters);

	void deleteNotFoundItems(Slideshow slideshow, Map<String, String[]> parameters);

	void deleteItems(Slideshow slideshow, Set<SlideshowItem> deletedItems);

	void updateModifiedItemsFromParameters(Slideshow slideshow, Map<String, String[]> parameters);

	void updateSlideshowItems(Integer slideshowId, Map<String, String[]> parameters, MultipartFile[] newItemsFiles);

	void addNewSlideshowItemsFromParameter(Slideshow slideshow, Map<String, String[]> parameters,
			MultipartFile[] newItemsFiles);

	Slideshow getSlideshowForShowById(int id);

}
