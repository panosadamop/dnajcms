package com.dnacreative.module.comment.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dnacreative.module.comment.model.Comment;

public interface CommentService {

	public void save(Comment comment);
	
	public Comment findById(Long id);

	public void deleteById(Long id);

	public List<Comment> findAllByType(Class<? extends Class> class1);

	public List<Comment> findAllContentComment();

	public Page<Comment> findAll(Pageable pageRequest);

	public void updateStatus(long id, String status);

	Set<Comment> findModuleCommentsByIdForShow(String itemType, Long itemId);

}
