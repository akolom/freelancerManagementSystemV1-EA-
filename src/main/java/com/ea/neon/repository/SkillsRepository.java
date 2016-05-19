package com.ea.neon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.neon.domain.Skills;
import com.ea.neon.domain.Skills.SkillTitle;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {

	Skills findOneBySkillTitle(SkillTitle skillTitle);

}
