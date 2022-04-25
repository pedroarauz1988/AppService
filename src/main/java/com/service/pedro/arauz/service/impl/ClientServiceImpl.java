package com.service.pedro.arauz.service.impl;

import com.service.pedro.arauz.entity.Client;
import com.service.pedro.arauz.entity.Person;
import com.service.pedro.arauz.exception.ValidationException;
import com.service.pedro.arauz.presentation.presenter.ClientPresenter;
import com.service.pedro.arauz.presentation.presenter.PersonPresenter;
import com.service.pedro.arauz.repository.ClientRepository;
import com.service.pedro.arauz.repository.PersonRepository;
import com.service.pedro.arauz.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public ClientPresenter save(ClientPresenter clientPresenter) throws ParseException {
        Person person;
        Client client;
        person = personRepository.save(buildPersonFromPresenter(clientPresenter.getPersonPresenter()));
        client = getClientFromPresenter(clientPresenter, person);
        client = clientRepository.save(client);
        return getClientPresenterFromEntity(client);
    }

    @Override
    public ClientPresenter getClient(String identification) {
        Optional<Client> client;
        ClientPresenter clientPresenter = new ClientPresenter();
        client = clientRepository.findByIdentification(identification);

        if (client.isPresent()) {
            clientPresenter = getClientPresenterFromEntity(client.get());
        } else {
            throw new ValidationException("Cliente no existe");
        }
        return clientPresenter;
    }

    @Override
    public List<ClientPresenter> getAllClient() {
       return StreamSupport.stream(clientRepository.findAll().spliterator(), false)
               .map(this::getClientPresenterFromEntity)
               .collect(Collectors.toList());
    }

    private ClientPresenter getClientPresenterFromEntity(Client client){
        return ClientPresenter
                .builder()
                .id(client.getId())
                .password(client.getPassword())
                .personPresenter(buildPersonPresenterFromEntity(client.getPerson()))
                .build();
    }

    private Client getClientFromPresenter(ClientPresenter clientPresenter, Person person){
        return Client
                .builder()
                .id(clientPresenter.getId())
                .password(clientPresenter.getPassword())
                .person(person)
                .build();
    }
    private PersonPresenter buildPersonPresenterFromEntity(Person person) {
        return PersonPresenter
                .builder()
                .name(person.getName())
                .phone(person.getPhone())
                .address(person.getAddress())
                .age(person.getAge())
                .gender(person.getGender())
                .identification(person.getIdentification())
                .build();
    }

    private Person buildPersonFromPresenter(PersonPresenter personPresenter) {
        return Person
                .builder()
                .id(personPresenter.getId())
                .name(personPresenter.getName())
                .phone(personPresenter.getPhone())
                .address(personPresenter.getAddress())
                .age(personPresenter.getAge())
                .gender(personPresenter.getGender())
                .identification(personPresenter.getIdentification())
                .build();
    }
}