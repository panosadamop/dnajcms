package com.dnacreative.module.comment.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dnacreative.module.comment.model.Comment;
import com.dnacreative.module.comment.service.CommentService;


@Controller("Admin CommentController")
@RequestMapping(value="/admin/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	private final String MODULE_TEMPLATE_ROOT = "admin/module/comment/";

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, @RequestParam(defaultValue = "1") int page) {
		page--;
		Pageable pageRequest = new PageRequest(page, 10/*pageSize*/, Sort.Direction.DESC, "id");
		Page<Comment> result = commentService.findAll(pageRequest);
	        System.out.println(result);
	    model.addAttribute("page", result);
		
		return MODULE_TEMPLATE_ROOT + "index";
	}
	
	@RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.POST)
	public String changeStatus(Model model, @PathVariable long id, @RequestParam String status) {
		
		commentService.updateStatus(id, status);
		
		return "redirect:/admin/comment/index";
	}
}
