package com.iiitb.majorproject.dao;

import com.iiitb.majorproject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectDao extends JpaRepository<Project,Long> {
    public List<Project> findAllByTa(String ta);
    @Query(value = "SELECT * FROM project U WHERE U.name=?",nativeQuery= true)
    public Project findByName(String name);

}
