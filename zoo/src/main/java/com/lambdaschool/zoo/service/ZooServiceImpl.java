package com.lambdaschool.zoo.service;


import com.lambdaschool.zoo.model.Zoo;
import com.lambdaschool.zoo.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    private ZooRepository zoorepos;

    @Override
    public ArrayList<Zoo> findAll()
    {
        ArrayList<Zoo> list = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    @Override
    public Zoo findZooByName(String name)
    {
        Zoo zoo = zoorepos.findByZooname(name);

        if(zoo == null)
        {
            throw new EntityNotFoundException();
        }
        return zoo;
    }

    @Transactional
    @Override
    public void deleteById(long id) throws EntityNotFoundException
    {
        if (zoorepos.findById(id).isPresent())
        {
            zoorepos.deletePhoneRecordsByZooid(id);
            zoorepos.deleteZooFromAnimalRecords(id);
            zoorepos.deleteById(id);
        }else
        {
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    @Override
    public Zoo addZoo(Zoo zoo)
    {
        zoorepos.addZoo(zoo.getZooname(), zoo.getZooid());
        return zoo;
    }


    @Transactional
    @Override
    public Zoo updateZoo(Zoo zoo, long id)
    {
        zoorepos.updateZoo(zoo.getZooname(), zoo.getZooid());
        return zoo;
    }
}
