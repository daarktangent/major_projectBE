package com.iiitb.majorproject.dao;

import com.iiitb.majorproject.entity.Project;
import com.iiitb.majorproject.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, String> {

    @Query(value = "SELECT user_id FROM user U INNER JOIN user_role UR ON U.user_name= UR.user_id WHERE UR.role_id='TA'",nativeQuery= true)
    public List<String> getAllTa();
}
