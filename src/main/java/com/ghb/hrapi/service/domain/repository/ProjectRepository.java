package com.ghb.hrapi.service.domain.repository;

import com.ghb.hrapi.service.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alexg on 3/8/2017.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
