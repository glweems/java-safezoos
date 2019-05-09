package com.lambdaschool.zoo.controller;


import com.lambdaschool.zoo.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooController
{

    @Autowired
    private ZooService zooService;

    @GetMapping(value = "/allzoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/allzoos/{name}", produces = {"application/json"})
    public ResponseEntity<?> getZooByName(@PathVariable String name)
    {
        return new ResponseEntity<>(zooService.findZooByName(name), HttpStatus.OK);
    }

}
