package com.lambdaschool.zoo.service;


import com.lambdaschool.zoo.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "telephoneService")
public class TelephoneServiceImpl implements TelephoneService
{
    @Autowired
    private TelephoneRepository telephonerepos;
}
