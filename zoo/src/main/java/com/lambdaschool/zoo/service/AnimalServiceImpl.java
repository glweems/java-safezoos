package com.lambdaschool.zoo.service;


import com.lambdaschool.zoo.model.Animal;
import com.lambdaschool.zoo.repository.AnimalRepository;
import com.lambdaschool.zoo.view.CountZoosWithAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService
{
    @Autowired
    private AnimalRepository animalrepos;

    @Override
    public ArrayList<Animal> findAll()
    {
        ArrayList<Animal> animalList = new ArrayList<>();
        animalrepos.findAll().iterator().forEachRemaining(animalList::add);
        return animalList;
    }

    @Override
    public Animal findAnimalByName(String name) throws EntityNotFoundException
    {
        Animal animal = animalrepos.findAnimalByAnimaltype(name);

        if(animal == null)
        {
            throw new EntityNotFoundException();
        }
        return animal;
    }

    @Override
    public ArrayList<CountZoosWithAnimal> getCountZoosWithAnimal()
    {
        return animalrepos.getCountZoosWithAnimal();
    }
}
