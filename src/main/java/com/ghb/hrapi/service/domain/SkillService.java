package com.ghb.hrapi.service.domain;

import com.ghb.hrapi.service.domain.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by agheboianu on 07.03.2017.
 */
@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;


}
