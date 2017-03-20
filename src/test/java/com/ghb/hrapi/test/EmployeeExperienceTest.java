package com.ghb.hrapi.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghb.hrapi.service.business.EmployeeExperienceService;
import org.hashids.Hashids;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by agheboianu on 08.03.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class EmployeeExperienceTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private EmployeeExperienceService employeeExperienceService;

    private static final Hashids hashids = new Hashids("u8qb17mh8c");


    @Test
    public void employeeSkillsReflectedInRead() throws Exception {
        MediaType json = MediaType.APPLICATION_JSON_UTF8;
        this.mvc
                .perform(get("/employees/" + hashids.encode(1) + "/skills"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(json))
                .andExpect(
                        mvcResult -> {
                            String contentAsString = mvcResult.getResponse().getContentAsString();
                            assertTrue(contentAsString.split("},").length == 3);
                        });
    }

}
