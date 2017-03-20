package com.ghb.hrapi.service.domain.repository;

import com.ghb.hrapi.service.domain.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by agheboianu on 07.03.2017.
 */
public interface SkillRepository extends JpaRepository<Skill,Long>{
}
