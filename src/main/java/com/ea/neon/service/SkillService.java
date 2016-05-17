package com.ea.neon.service;

import java.util.List;

import com.ea.neon.domain.Skills;

public interface SkillService {

	public List<Skills> findAll();

	public Skills getSkillById(Integer id);
	
}
