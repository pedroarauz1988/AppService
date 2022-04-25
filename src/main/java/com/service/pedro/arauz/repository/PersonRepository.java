package com.service.pedro.arauz.repository;

import com.service.pedro.arauz.entity.Client;
import com.service.pedro.arauz.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {

}
