package com.dnacreative.module.content.service;

import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dnacreative.module.content.model.Content;
import com.dnacreative.module.content.repository.ContentRepository;

@RunWith(MockitoJUnitRunner.class)
public class ContentServiceTest {

	@Mock
	ContentRepository contentRepository;
	
	@InjectMocks
	private ContentService contentService= new ContentServiceImp();
	
	private Map<String, String[]> parameters;
	
	// content
	private final Long contentId1=1L;
	private Content content1;
	
	@Before
	public void setup() {
		
		parameters = new HashMap<String, String[]>();
		
		// slideshow
		content1 = new Content();
		content1.setId(contentId1);
	
	}
	
	@Test
	public void findByIdForShow_verifyCallRepository() {
		
		contentService.findByIdForShow(contentId1);
		
		verify(contentRepository).findByIdForShow(contentId1);
	}
	
	@Test
	public void getForCatListContents_() {
		Integer categoryId=1;
		int pageSize=10;
		String slug = "test-1";
		int page = 1;
		
		Pageable pageRequest = new PageRequest(page-1, pageSize/*pageSize*/, Sort.Direction.DESC, "id");
		//when(contentRepository.getForCatList())
		
		Page<Content> result = contentService.getForCatListContents(categoryId, page, pageSize);
		
		verify(contentRepository).findForCatListContents(categoryId, pageRequest);
	}
}
