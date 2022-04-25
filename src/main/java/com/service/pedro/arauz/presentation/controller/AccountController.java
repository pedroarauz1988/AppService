package com.service.pedro.arauz.presentation.controller;

import com.service.pedro.arauz.presentation.presenter.AccountPresenter;
import com.service.pedro.arauz.presentation.presenter.ClientPresenter;
import com.service.pedro.arauz.service.AccountService;
import com.service.pedro.arauz.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/cuentas")
    public AccountPresenter saveAccountPresenter(@RequestBody AccountPresenter accountPresenter) throws ParseException {
        return accountService.save(accountPresenter);
    }


}
