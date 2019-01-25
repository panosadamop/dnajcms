package com.dnacreative.module.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dnacreative.core.lib.exception.ResourceNotFoundException;
import com.dnacreative.core.util.pagination.PageWrapper;
import com.dnacreative.module.category.model.Category;
import com.dnacreative.module.category.service.CategoryService;
import com.dnacreative.module.content.model.Content;
import com.dnacreative.module.content.service.ContentService;
import com.dnacreative.module.menu.repository.MenuRepository;
import com.dnacreative.module.page.service.PageService;
import com.dnacreative.module.slideshow.model.Slideshow;
import com.dnacreative.module.slideshow.service.SlideshowService;

@Controller
public class PageController {

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SlideshowService slideshowService;
	
	@Autowired
	private PageService pageService;
	
	private final String MODULE_TEMPLATE_ROOT = "site/module/page/";
	private final int MODULE_CONTENT_ID = 1;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {

		
		int categoryId = 1;
		Page<Content> result = contentService.getForCatListContents(categoryId, 1,3);
		PageWrapper<Content> pagination = new PageWrapper<Content>(result, "/blog");
		Category category = categoryService.findById(categoryId);
		
		model.addAttribute("category", category);
		model.addAttribute("contents", result);
		model.addAttribute("pagination", pagination);
		
		Slideshow slideshow = slideshowService.getSlideshowForShowById(1);
		model.addAttribute("slideshow", slideshow);
		return MODULE_TEMPLATE_ROOT + "home";
	}
	
	@RequestMapping(value="p-{id}/{slug}", method=RequestMethod.GET)
	public String pageShow(@PathVariable Integer id, @PathVariable String slug,Model model) {
		
		com.dnacreative.module.page.model.Page page = pageService.findById(id);
		
		if(page == null) {
			throw new ResourceNotFoundException();
		}
		
		if(!slug.equals(page.getSlug())) {
			return "redirect:/p-"+id+"/"+page.getSlug();
		}
		
		model.addAttribute("page", page);
		return MODULE_TEMPLATE_ROOT + "showpage";
	}

}
