package com.lambdaschool.zoo.repository;

import com.lambdaschool.zoo.model.Animal;
import com.lambdaschool.zoo.view.CountZoosWithAnimal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    public Animal findAnimalByAnimaltype(String type);

    @Query(value = "SELECT z.animalid, animaltype, count(zooid) as countzoos FROM zooanimals z INNER JOIN animal a ON z.animalid = a.animalid GROUP BY z.animalid, animaltype", nativeQuery = true)
    ArrayList<CountZoosWithAnimal> getCountZoosWithAnimal();

}
