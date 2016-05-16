package com.ea.neon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.neon.domain.Category;
import com.ea.neon.domain.User;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	


}
