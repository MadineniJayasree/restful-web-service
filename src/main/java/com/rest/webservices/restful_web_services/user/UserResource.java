package com.rest.webservices.restful_web_services.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    private UserDaoService userDaoService;
    public UserResource(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }
    @GetMapping(path ="/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findOne(@PathVariable int id){
        return userDaoService.findOne(id);
    }
}
