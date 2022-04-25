package com.service.pedro.arauz.repository;

import com.service.pedro.arauz.entity.Client;
import com.service.pedro.arauz.presentation.presenter.ClientPresenter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends CrudRepository<Client, UUID> {

    @Query("select c from Client c join c.person p where p.identification = :identification")
    Optional<Client> findByIdentification(String identification);

}
