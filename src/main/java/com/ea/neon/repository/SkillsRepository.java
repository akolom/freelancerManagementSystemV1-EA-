package com.ea.neon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ea.neon.domain.Experience;
import com.ea.neon.domain.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer>{

	@Query(nativeQuery=true,value="select * from Skills e, Freelancer f where e.skills_id = f.id and f.id=?1")
	List<Skills> findByFreelancer(Integer id);
}
