package com.service.pedro.arauz.repository;

import com.service.pedro.arauz.entity.Account;
import com.service.pedro.arauz.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<Account, UUID> {

}
