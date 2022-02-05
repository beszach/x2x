package com.example.pptaskspringboot.rest.controller;

import com.example.pptaskspringboot.rest.model.Role;
import com.example.pptaskspringboot.rest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleRestController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

}