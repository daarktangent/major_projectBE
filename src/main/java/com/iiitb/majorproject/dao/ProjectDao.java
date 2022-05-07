package com.iiitb.majorproject.dao;

import com.iiitb.majorproject.entity.Project;
import com.iiitb.majorproject.service.ProjectService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectDao extends JpaRepository<Project,Long> {

}
