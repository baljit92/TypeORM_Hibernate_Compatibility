package com.example.hibernate.controllers;

import java.util.List;


import com.example.hibernate.entities.Info;
import com.example.hibernate.entities.InfoDTO;
import com.example.hibernate.entities.User;
import com.example.hibernate.repositories.InfoRepository;
import com.example.hibernate.repositories.UserRepository;
import com.example.hibernate.response_formats.UserShowJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    InfoRepository infoRepository;

    // localhost:8080/api/users/all
    @GetMapping(value = "/users/all", produces = "application/json")
    public List<User> displayUsers() {
        return userRepository.findAll();
    }

    // localhost:8080/api/users/1/submissions
    @GetMapping(value = "/users/{id}/submissions", produces = "application/json")
    public UserShowJson displayInfosForUser(@PathVariable Long id) {
        UserShowJson json = new UserShowJson();

        List<InfoDTO> infos = infoRepository.findInfosForUser(id);

        json.info = infos;

        return json;
    }

    //localhost:8080/api/users
    @PostMapping(value="/users")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }

    //localhost:8080/api/users/1
    @DeleteMapping(value="/users/{id}")
    public void deleteUser(@PathVariable("id") long id){

        User existingUser = userRepository.findById(id).orElse(new User());
        if(existingUser.getId() != null){
            List<Info> infos =  infoRepository.findAllByUserId(existingUser.getId());
            infoRepository.deleteAll(infos);

            userRepository.delete(existingUser);
        }
    }

}