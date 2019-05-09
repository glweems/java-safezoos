package com.lambdaschool.zoo.repository;

import com.lambdaschool.zoo.model.Telephone;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneRepository extends CrudRepository<Telephone, Long>
{
}
