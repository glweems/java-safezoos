package com.lambdaschool.zoo.model;


import com.lambdaschool.zoo.view.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animal")
public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.AnimalsOnly.class)
    private long animalid;


    @JsonView(View.AnimalsOnly.class)
    private String animaltype;


    @ManyToMany(mappedBy = "animal")
    @JsonIgnore
    private List<Zoo> zoos = new ArrayList<>();

    public Animal()
    {
    }

    public Animal(long animalid, String animaltype, List<Zoo> zoos)
    {
        this.animalid = animalid;
        this.animaltype = animaltype;
        this.zoos = zoos;
    }

    public long getAnimalid()
    {
        return animalid;
    }

    public void setAnimalid(long animalid)
    {
        this.animalid = animalid;
    }

    public String getAnimaltype()
    {
        return animaltype;
    }

    public void setAnimaltype(String animaltype)
    {
        this.animaltype = animaltype;
    }

    public List<Zoo> getZoos()
    {
        return zoos;
    }

    public void setZoos(List<Zoo> zoos)
    {
        this.zoos = zoos;
    }
}
