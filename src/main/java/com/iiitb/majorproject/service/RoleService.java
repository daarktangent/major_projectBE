package com.iiitb.majorproject.service;

import com.iiitb.majorproject.dao.RoleDao;
import com.iiitb.majorproject.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role){
        return roleDao.save(role);
    }
}
