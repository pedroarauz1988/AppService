package com.service.pedro.arauz.presentation.controller;

import com.service.pedro.arauz.presentation.presenter.AccountPresenter;
import com.service.pedro.arauz.presentation.presenter.MovementPresenter;
import com.service.pedro.arauz.service.AccountService;
import com.service.pedro.arauz.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@CrossOrigin
public class MovementController {

    @Autowired
    MovementService movementService;

    @PostMapping("/movimientos")
    public MovementPresenter saveMovementPresenter(@RequestBody MovementPresenter movementPresenter) throws ParseException {
        return movementService.save(movementPresenter);
    }


}
