package com.service.pedro.arauz.service.impl;

import com.service.pedro.arauz.entity.Account;
import com.service.pedro.arauz.entity.Client;
import com.service.pedro.arauz.entity.Person;
import com.service.pedro.arauz.presentation.presenter.AccountPresenter;
import com.service.pedro.arauz.presentation.presenter.ClientPresenter;
import com.service.pedro.arauz.presentation.presenter.PersonPresenter;
import com.service.pedro.arauz.repository.AccountRepository;
import com.service.pedro.arauz.repository.ClientRepository;
import com.service.pedro.arauz.repository.PersonRepository;
import com.service.pedro.arauz.service.AccountService;
import com.service.pedro.arauz.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public AccountPresenter save(AccountPresenter accountPresenter) throws ParseException {
        Account account;
        account = accountRepository.save(getAccountFromPresenter(accountPresenter));
        return getAccountPresenterFromEntity(account);
    }

    private AccountPresenter getAccountPresenterFromEntity(Account account){
        return AccountPresenter
                .builder()
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .initialAmount(account.getInitialAmount())
                .status(account.getStatus())
                .clientPresenter(getClientPresenterFromEntity(account.getClient()))
                .build();
    }

    private Account getAccountFromPresenter(AccountPresenter accountPresenter){
        return Account
                .builder()
                .accountNumber(accountPresenter.getAccountNumber())
                .accountType(accountPresenter.getAccountType())
                .initialAmount(accountPresenter.getInitialAmount())
                .status(accountPresenter.getStatus())
                .client(getClientFromPresenter(accountPresenter.getClientPresenter()))
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

    private Client getClientFromPresenter(ClientPresenter clientPresenter){
        return Client
                .builder()
                .id(clientPresenter.getId())
                .password(clientPresenter.getPassword())
                .person(buildPersonFromPresenter(clientPresenter.getPersonPresenter()))
                .build();
    }

    private Person buildPersonFromPresenter(PersonPresenter personPresenter) {
        return Person
                .builder()
                .name(personPresenter.getName())
                .phone(personPresenter.getPhone())
                .address(personPresenter.getAddress())
                .age(personPresenter.getAge())
                .gender(personPresenter.getGender())
                .identification(personPresenter.getIdentification())
                .build();
    }
    private ClientPresenter getClientPresenterFromEntity(Client client){
        return ClientPresenter
                .builder()
                .password(client.getPassword())
                .personPresenter(buildPersonPresenterFromEntity(client.getPerson()))
                .build();
    }
}