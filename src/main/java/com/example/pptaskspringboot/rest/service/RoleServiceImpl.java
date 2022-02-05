package com.example.pptaskspringboot.rest.service;

import com.example.pptaskspringboot.rest.dao.RoleRepozitory;
import com.example.pptaskspringboot.rest.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepozitory roleRepozitory;

    @Override
    public List<Role> getRoles() {
        return roleRepozitory.findAll();
    }
}
