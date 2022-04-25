package com.service.pedro.arauz.service;

import com.service.pedro.arauz.presentation.presenter.AccountPresenter;
import com.service.pedro.arauz.presentation.presenter.MovementPresenter;

import java.text.ParseException;

public interface MovementService {

    MovementPresenter save(MovementPresenter movementPresenter) throws ParseException;
}
