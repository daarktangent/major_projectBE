package com.iiitb.majorproject.service;


import com.iiitb.majorproject.dao.ProjectDao;
import com.iiitb.majorproject.dao.UserDao;
import com.iiitb.majorproject.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        projectDao.save(project);
        return project;
    }

    public void delete(Long id)
    {
        projectDao.deleteById(id);
    }
    public Optional<Project> getProjectById(Long id)
    {
        return projectDao.findById(id);
    }
}
