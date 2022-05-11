package com.iiitb.majorproject.service;


import com.iiitb.majorproject.dao.ProjectDao;
import com.iiitb.majorproject.dao.UserDao;
import com.iiitb.majorproject.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private UserDao userDao;

    public List<Project> getAAllProject()
    {
        return projectDao.findAll();
    }


    public Project save(Project project) {
        List<String> listOfTa=userDao.getAllTa();
        Random rand = new Random();
        String temp=listOfTa.get(rand.nextInt(listOfTa.size()));
        System.out.println(temp);
        project.setTa(temp);
        projectDao.save(project);
        return project;
    }
    public Project saveUpdate(Project project)
    {
         return projectDao.save(project);
    }

    public void delete(Long id)
    {
        projectDao.deleteById(id);
    }
    public Optional<Project> getProjectById(Long id)
    {
        return projectDao.findById(id);
    }

    public List<Project> getAllProjectBelongingToaTa(String userName)
    {
        return projectDao.findAllByTa(userName);
    }

    public Project getProjectByUserName(String name)
    {
        return projectDao.findByName(name);
    }
}
