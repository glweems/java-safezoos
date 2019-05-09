package com.lambdaschool.zoo.service;

import com.lambdaschool.zoo.model.Animal;
import com.lambdaschool.zoo.view.CountZoosWithAnimal;

import java.util.ArrayList;

public interface AnimalService
{

    public ArrayList<Animal> findAll();

    public Animal findAnimalByName(String name);

    public ArrayList<CountZoosWithAnimal> getCountZoosWithAnimal();

}
