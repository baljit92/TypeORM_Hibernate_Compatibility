package com.example.hibernate.controllers;

import java.util.List;

import com.example.hibernate.entities.Info;
import com.example.hibernate.repositories.InfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class InfoController {

    @Autowired
    InfoRepository infoRepository;

    //localhost:8080/api/info/all
    @GetMapping(value="/info/all", produces="application/json")
    public List<Info> displayinfos() {
        return infoRepository.findAll();
    }

    //localhost:8080/api/info
    @PostMapping(value="/info")
    public void addinfo(@RequestBody Info info){
        infoRepository.save(info);
    }

}