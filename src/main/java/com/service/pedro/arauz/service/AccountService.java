package com.service.pedro.arauz.service;

import com.service.pedro.arauz.presentation.presenter.AccountPresenter;
import com.service.pedro.arauz.presentation.presenter.ClientPresenter;

import java.text.ParseException;

public interface AccountService {

    AccountPresenter save(AccountPresenter accountPresenter) throws ParseException;
}
