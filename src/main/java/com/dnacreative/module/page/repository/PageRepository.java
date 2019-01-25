package com.dnacreative.module.page.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnacreative.module.page.model.Page;

public interface PageRepository extends JpaRepository<Page, Integer>{

	Page findById(int i);

	Page findTop1ByOrderByIdDesc();

}
