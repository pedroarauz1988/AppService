package com.service.pedro.arauz.service.impl;

import com.service.pedro.arauz.entity.Account;
import com.service.pedro.arauz.entity.Client;
import com.service.pedro.arauz.entity.Movement;
import com.service.pedro.arauz.entity.Person;
import com.service.pedro.arauz.enums.MovementType;
import com.service.pedro.arauz.presentation.presenter.AccountPresenter;
import com.service.pedro.arauz.presentation.presenter.ClientPresenter;
import com.service.pedro.arauz.presentation.presenter.MovementPresenter;
import com.service.pedro.arauz.presentation.presenter.PersonPresenter;
import com.service.pedro.arauz.repository.AccountRepository;
import com.service.pedro.arauz.repository.MovementRepository;
import com.service.pedro.arauz.service.AccountService;
import com.service.pedro.arauz.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    MovementRepository movementRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public MovementPresenter save(MovementPresenter movementPresenter) throws ParseException {
        Movement movement;
        BigDecimal balanceAccount;
        BigDecimal balance;
        Optional<Account> account;

        account = accountRepository.findById(movementPresenter.getAccountPresenter().getId());

        if(!account.get().getMovements().isEmpty())
        {
            account.get().getMovements().sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));
            balanceAccount = account.get().getMovements().stream().findFirst().get().getBalance();

        } else {
            balanceAccount = movementPresenter.getAccountPresenter().getInitialAmount();
        }
        if (movementPresenter.getMovementType() == MovementType.DEPOSITO) {
                balance = balanceAccount.add(movementPresenter.getAmount());
        } else {
                balance = balanceAccount.subtract(movementPresenter.getAmount());
        }


        movementPresenter.setBalance(balance);
        movementPresenter.setDate(new Date());
        movement = movementRepository.save(getMovementFromPresenter(movementPresenter));
        return getMovementPresenterFromEntity(movement);
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

    private MovementPresenter getMovementPresenterFromEntity(Movement movement){
        return MovementPresenter
                .builder()
                .movementType(movement.getMovementType())
                .date(movement.getDate())
                .observation(movement.getObservation())
                .amount(movement.getAmount())
                .balance(movement.getBalance())
                .accountPresenter(getAccountPresenterFromEntity(movement.getAccount()))
                .build();
    }

    private Movement getMovementFromPresenter(MovementPresenter movementPresenter){
        return Movement
                .builder()
                .movementType(movementPresenter.getMovementType())
                .date(movementPresenter.getDate())
                .observation(movementPresenter.getObservation())
                .amount(movementPresenter.getAmount())
                .balance(movementPresenter.getBalance())
                .account(getAccountFromPresenter(movementPresenter.getAccountPresenter()))
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

    private Account getAccountFromPresenter(AccountPresenter accountPresenter){
        return Account
                .builder()
                .id(accountPresenter.getId())
                .accountNumber(accountPresenter.getAccountNumber())
                .accountType(accountPresenter.getAccountType())
                .initialAmount(accountPresenter.getInitialAmount())
                .status(accountPresenter.getStatus())
                .client(getClientFromPresenter(accountPresenter.getClientPresenter()))
                .build();
    }

}