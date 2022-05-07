package com.iiitb.majorproject.service;

import com.iiitb.majorproject.dao.RoleDao;
import com.iiitb.majorproject.dao.UserDao;
import com.iiitb.majorproject.entity.Role;
import com.iiitb.majorproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userdao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public User registerNewUser(User user){

        Role role = roleDao.findById("User").get();

        Set<Role> roles =new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setUserPassword( getEncodedPassword(user.getUserPassword()));

        return userdao.save(user);
    }

    public User registerNewTA(User user){

        Role role = roleDao.findById("TA").get();

        Set<Role> roles =new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setUserPassword( getEncodedPassword(user.getUserPassword()));

        return userdao.save(user);
    }

    public void initRolesAndUser(){
        Role adminRole= new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole= new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User Role");
        roleDao.save(userRole);

        Role taRole= new Role();
        userRole.setRoleName("TA");
        userRole.setRoleDescription("TA role");
        roleDao.save(userRole);

        User adminUser= new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        Set<Role> adminRoles= new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userdao.save(adminUser);

//        User user= new User();
//        user.setUserFirstName("roopam");
//        user.setUserLastName("patil");
//        user.setUserName("roopam123");
//        user.setUserPassword(getEncodedPassword("roopam@pass"));
//        Set<Role> userRoles= new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userdao.save(user);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);

    }
}
