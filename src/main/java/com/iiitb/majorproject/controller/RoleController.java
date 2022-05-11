package com.iiitb.majorproject.controller;

import com.iiitb.majorproject.entity.Role;
import com.iiitb.majorproject.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private static final Logger logger= LogManager.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role){
        logger.info("Created role entered");
        return roleService.createNewRole(role);

    }
}
