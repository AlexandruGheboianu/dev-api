package com.ghb.hrapi.api;

import com.ghb.hrapi.api.apimodel.create.EmployeeAdd;
import com.ghb.hrapi.api.apimodel.list.EmployeeListModel;
import com.ghb.hrapi.api.apimodel.list.EmployeeSkillListModel;
import com.ghb.hrapi.service.business.EmployeeExperienceService;
import com.ghb.hrapi.service.domain.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by agheboianu on 02.03.2017.
 */

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeExperienceService employeeExperienceService;

    @RequestMapping(method = RequestMethod.GET)
    public Page<EmployeeListModel> employees(Pageable pageable) {
        return employeeService.listEmployees(pageable);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public EmployeeListModel employee(@PathVariable String id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}/skills")
    public List<EmployeeSkillListModel> employeeSkills(@PathVariable String id) {
        return employeeExperienceService.getEmployeeSkills(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addEmployee(@RequestBody @Validated EmployeeAdd employeeAdd) {
        employeeService.addEmployee(employeeAdd);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
