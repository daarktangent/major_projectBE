package com.iiitb.majorproject;

import com.iiitb.majorproject.entity.Role;
import com.iiitb.majorproject.service.RoleService;
import com.iiitb.majorproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@EnableWebMvc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class MajorprojectApplicationTests extends AbstractTest{

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    WebApplicationContext webApplicationContext;
    protected MockMvc mvc;
    @BeforeEach
    protected void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Order(1)
    void contextLoads() {
    }

    @Test
    @Order(2)
    void  getAllProjectTest() throws Exception
    {
        String  uri = "/project";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        try {
            assertEquals( 200, status);
            System.out.println("Success");
        }catch(Exception e) {
            System.out.println("Fail");
        }
        String  content = mvcResult.getResponse().getContentAsString();
//        List<User> userList = super.mapFromJson(content, List.class);

    }
    @Test
    @Order(3)
    void  addProjectTest() throws Exception
    {
        String user = "{\"pid\":\"12\",\"uid\":\"test\",\"name\":\"ta\",\"approved\":\"true\",\"description\":\"test\",\"projectLink\":\"manager\"}";
        String  uri = "/project/add";
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(user)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();

        String content = mvcResult.getResponse().getContentAsString();
        try {
            assertEquals( 200, status);
            System.out.println("Register User : Success");
        }catch(Exception e) {
            System.out.println("Register User : Fail");
        }
    }
}


