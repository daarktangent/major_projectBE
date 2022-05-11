package com.iiitb.majorproject.controller;


import com.iiitb.majorproject.entity.Project;
import com.iiitb.majorproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @GetMapping("/project")
    public List<Project> test()
    {
        return projectService.getAAllProject();
    }
    @PostMapping("/project/add")
    public Project addProject(@RequestBody Project project )
    {
        project.setApproved(null);
        System.out.println("add project controller");
        return projectService.save(project);
    }
    @GetMapping("/project/{id}")
    public Optional<Project> getById(@PathVariable Long id)
    {
        return projectService.getProjectById(id);
    }

    @PutMapping("/project/update/{id}")
    public Project update(@PathVariable Long id,@RequestBody Project project)
    {
        project.setPid(id);
        projectService.saveUpdate(project);
        System.out.println(id+"reached update");
        return project;
    }
    @GetMapping("/project/all/{userName}")
    public List<Project> findAllProjectFromATa(@PathVariable String userName)
    {
        System.out.println(projectService.getAllProjectBelongingToaTa(userName));
        return projectService.getAllProjectBelongingToaTa(userName);
    }
    @GetMapping("/project/user/{userName}")
    public Project findByName(@PathVariable String userName) {
        return projectService.getProjectByUserName(userName);
    }
}
