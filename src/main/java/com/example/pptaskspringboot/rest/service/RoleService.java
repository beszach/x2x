package com.example.pptaskspringboot.rest.service;

import com.example.pptaskspringboot.rest.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {

    public List<Role> getRoles();
}

