package com.lambdaschool.zoo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
public class Zoo
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    private String zooname;


    @OneToMany(
            mappedBy = "zoo",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Telephone> phones = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "zooanimal",
               joinColumns = {@JoinColumn(name = "zooid")},
               inverseJoinColumns = {@JoinColumn(name = "animalid")})
    @JsonIgnore
    private List<Animal> animal = new ArrayList<>();




    public Zoo()
    {
    }

    public Zoo(long zooid, String zooname, List<Telephone> phones, List<Animal> animal)
    {
        this.zooid = zooid;
        this.zooname = zooname;
        this.phones = phones;
        this.animal = animal;
    }

    public long getZooid()
    {
        return zooid;
    }

    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public List<Telephone> getPhones()
    {
        return phones;
    }

    public void setPhones(List<Telephone> phones)
    {
        this.phones = phones;
    }

    public List<Animal> getAnimals()
    {
        return animal;
    }

    public void setAnimals(List<Animal> animals)
    {
        this.animal = animals;
    }

    @Override
    public String toString()
    {
        return "Zoo{" + "zooid=" + zooid + ", zooname='" + zooname + '\'' + ", phones=" + phones + ", animal=" + animal + '}';
    }
}
