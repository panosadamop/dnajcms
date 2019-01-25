package com.dnacreative.module.module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dnacreative.module.module.model.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer>{
	
}
