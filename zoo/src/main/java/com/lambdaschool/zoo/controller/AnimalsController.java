package com.lambdaschool.zoo.controller;


import com.lambdaschool.zoo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/animals")
public class AnimalsController
{

    @Autowired
    private AnimalService animalService;


    @GetMapping(value = "/animals", produces = {"application/json"})
    public ResponseEntity<?> getAllAnimals()
    {
        return new ResponseEntity<>(animalService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{name}", produces = {"application/json"})
    public ResponseEntity<?> getAnimalByName(@PathVariable String name)
    {
        return new ResponseEntity<>(animalService.findAnimalByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/count", produces = {"application/json"})
    public ResponseEntity<?> getCountZoosWithAnimal()
    {
        return new ResponseEntity<>(animalService.getCountZoosWithAnimal(), HttpStatus.OK);
    }
}
